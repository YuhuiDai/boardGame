package impl.view;

import java.util.Observable;
import java.util.Scanner;

import api.Chip;
import api.Game;
import api.View;
import exc.GameStateException;
import exc.IllegalMoveException;
import impl.game.ConnectFour;

public class Console extends View {
	Observable observable;
	
	public Console(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Game game = null;
		if(o instanceof Game){
			game = (Game) o;
			this.render(game);
		}
		
		while (! game.isGameOver()){
			
			System.out.println(game.getCurrentPlayer());
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Enter Column number: ");
			int col = reader_admin.nextInt();
		
			try {
				game.placeDisk(col);
			} catch (IllegalMoveException e1) {
				System.out.println("Input Out of bounds, choose row again: ");
				
			} catch (GameStateException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void render(Game game) {
		for (int c=0; c<game.getColumns(); c++){
			System.out.print(c + " ");
		}
		System.out.println();
		
		for (int r=0; r<game.getRows(); r++){
			for (int c=0; c < game.getColumns(); c++) {
				if (game.getBoard()[r][c] == Chip.EMPTY) {
					System.out.print(". ");
				} else if (game.getBoard()[r][c] == Chip.BLUE) {
					System.out.print("B ");
				} else if (game.getBoard()[r][c] == Chip.RED) {
					System.out.print("R ");
				}	
			}
			System.out.println();
		}
		System.out.println();
	}
	
}