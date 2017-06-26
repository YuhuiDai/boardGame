package impl.view;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.Math;

import api.Chip;
import api.Game;
import exc.GameStateException;
import exc.IllegalMoveException;
import impl.game.ConnectFour;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public abstract class Graphical extends Application /* implements Observer */ {
	
	public abstract Game createGame();
	Game game = createGame();
	BorderPane borderpane = new BorderPane();
	GridPane pane = new GridPane();
	Circle circleRed = empty();
	Circle circleBlue = empty();
	Circle circleWin = empty();
	VBox v = createVbox();
	Text winner;

	private VBox createVbox() {
		VBox vBox = new VBox(35);
		
		// add static element in vBox on the left
		Text curP = new Text("Current Player:");
		curP.setFont(Font.font ("Verdana", 20));
		Text win = new Text("Winner:");
		win.setFont(Font.font ("Verdana", 20));
		
		vBox.getChildren().addAll(curP,circleRed,circleBlue,win, circleWin);
		vBox.setPadding(new Insets(15,15,15,15));
		
		return vBox;
	}
	
	
	private Circle red() {
		Circle circle = new Circle();
		circle.setRadius(35);
		circle.setFill(Color.RED);
		circle.setStroke(Color.GREY);
		circle.setOnMouseClicked((MouseEvent e) -> {
			if (winner != null && v.getChildren().size() == 6) {
				v.getChildren().remove(5);
			}
			Circle source = (Circle) e.getSource() ;
			try{
				
				if (!game.isGameOver()) {
					Integer colIndex = GridPane.getColumnIndex(source);
					
					game.placeDisk(colIndex); 
					this.render();
				} 
				if (game.isGameOver()) {
					if (game.getWinningPlayer() == Chip.RED) {
						circleWin.setFill(Color.RED);
						winner = new Text("The Winner is Red");
						winner.setFont(Font.font ("Verdana", 20));
						winner.setFill(Color.RED);
						v.getChildren().add(winner);
					} else if (game.getWinningPlayer() == Chip.BLUE) {
						circleWin.setFill(Color.BLUE);
						winner = new Text("The Winner is Blue");
						winner.setFont(Font.font ("Verdana", 20));
						winner.setFill(Color.BLUE);
						v.getChildren().add(winner);
					} 	
				} 
				
			}
			catch (IllegalMoveException a) {
				winner = new Text("Invalid Selection, try again");
				winner.setFont(Font.font ("Verdana", 20));
				winner.setFill(Color.GREEN);
				v.getChildren().add(winner);
				System.out.println("Input Out of bounds, click again: ");
			}
			catch (GameStateException a){
				circleWin.setFill(Color.BLACK);
				winner = new Text("A Tie");
				winner.setFont(Font.font ("Verdana", 20));
				v.getChildren().add(winner);
				System.out.println("a Tie");
			}
			
		});
	
		return circle;
	}
	private Circle blue() {
		Circle circle = new Circle();
		circle.setRadius(35);
		circle.setFill(Color.BLUE);
		circle.setStroke(Color.BLACK);
		circle.setOnMouseClicked((MouseEvent e) -> {
			if (winner != null && v.getChildren().size() == 6) {
				v.getChildren().remove(5);
			}
			Circle source = (Circle) e.getSource() ;
			try{
				
				if (!game.isGameOver()) {
					Integer colIndex = GridPane.getColumnIndex(source);
					
					game.placeDisk(colIndex); 
					this.render();
				} 
				if (game.isGameOver()) {
					if (game.getWinningPlayer() == Chip.RED) {
						circleWin.setFill(Color.RED);
						winner = new Text("The Winner is Red");
						winner.setFont(Font.font ("Verdana", 20));
						winner.setFill(Color.RED);
						v.getChildren().add(winner);
					} else if (game.getWinningPlayer() == Chip.BLUE) {
						circleWin.setFill(Color.BLUE);
						winner = new Text("The Winner is Blue");
						winner.setFont(Font.font ("Verdana", 20));
						winner.setFill(Color.BLUE);
						v.getChildren().add(winner);
					} 	
				}
				
			}
			catch (IllegalMoveException a) {
				winner = new Text("Invalid Selection, try again");
				winner.setFont(Font.font ("Verdana", 20));
				winner.setFill(Color.GREEN);
				v.getChildren().add(winner);
				System.out.println("Input Out of bounds, click again: ");
			}
			catch (GameStateException a){
				circleWin.setFill(Color.BLACK);
				winner = new Text("A Tie");
				winner.setFont(Font.font ("Verdana", 20));
				v.getChildren().add(winner);
				System.out.println("a Tie");
			}
			
		});
	
		return circle;
	}
	
	private Circle empty() {
		Circle circle = new Circle();
		circle.setRadius(35);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		circle.setOnMouseClicked((MouseEvent e) -> {
			if (winner != null && v.getChildren().size() == 6) {
				v.getChildren().remove(5);
			}
			Circle source = (Circle) e.getSource() ;
			try{
				
				if (!game.isGameOver()) {
					Integer colIndex = GridPane.getColumnIndex(source);
					game.placeDisk(colIndex); 
					this.render();
				} 
				
				if (game.isGameOver()) {
					if (game.getWinningPlayer() == Chip.RED) {
						circleWin.setFill(Color.RED);
						winner = new Text("The Winner is RED");
						winner.setFont(Font.font ("Verdana", 20));
						winner.setFill(Color.RED);
						v.getChildren().add(winner);
					} else if (game.getWinningPlayer() == Chip.BLUE) {
						circleWin.setFill(Color.BLUE);
						winner = new Text("The Winner is BLUE");
						winner.setFont(Font.font ("Verdana", 20));
						winner.setFill(Color.BLUE);
						v.getChildren().add(winner);
					} 
				} 
				
			}
			catch (IllegalMoveException a) {
				winner = new Text("Invalid Selection, try again");
				winner.setFont(Font.font ("Verdana", 20));
				winner.setFill(Color.GREEN);
				v.getChildren().add(winner);
				System.out.println("Input Out of bounds, click again: ");
			}
			catch (GameStateException a){
				circleWin.setFill(Color.BLACK);
				winner = new Text("A Tie");
				winner.setFont(Font.font ("Verdana", 20));
				v.getChildren().add(winner);
				System.out.println("a Tie");
			}
			
		});	
	
		return circle;
	}
	
	private void render(){
		// vBox rendi
		if (!game.isGameOver()) {
			if (game.getCurrentPlayer() == Chip.RED) {
				circleRed.setFill(Color.RED);
				circleBlue.setFill(Color.WHITE);
			} else if (game.getCurrentPlayer() == Chip.BLUE) {
				circleBlue.setFill(Color.BLUE);
				circleRed.setFill(Color.WHITE);
			}
		} else {
			circleRed.setFill(Color.WHITE);
			circleBlue.setFill(Color.WHITE);
		}
		
		
		for (int i=0;i<game.getRows();i++){
			for (int j=0;j<game.getColumns();j++){
				if (game.getBoard()[i][j] == Chip.RED){
					pane.add(red(),j,i);
				}
				else if (game.getBoard()[i][j] == Chip.BLUE){
					pane.add(blue(),j,i);
				}
				else{
					pane.add(empty(),j,i);
				}
				
			}
		}
		
		
	}
	
	public void update(){
		for (int i=0;i<game.getRows();i++){
			for (int j=0;j<game.getColumns();j++){
				if (game.getBoard()[i][j] == Chip.RED){
					pane.add(red(),j,i);
				}
				else if (game.getBoard()[i][j] == Chip.BLUE){
					pane.add(blue(),j,i);
				}
				else{
					pane.add(empty(),j,i);
				}
				
			}
		}
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		borderpane.setRight(pane);
		borderpane.setLeft(v);
		
		pane.setAlignment(Pos.CENTER_LEFT);
		pane.setPadding(new Insets(5, 50, 5, 5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
				
		render();
	
		Scene scene = new Scene(borderpane, 900, 800);
		if (game.getColumns() == 4) {
			stage.setTitle("Complica");
		} else if (game.getColumns() == 7) {
			stage.setTitle("Connect Four");
		}
		stage.setScene(scene);
		stage.show();		
	}
}
