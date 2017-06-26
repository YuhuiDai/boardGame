package impl.view;

import api.Game;
import impl.game.ConnectFour;
import javafx.application.Application;

public class ConnectFourGraphical extends Graphical {

	@Override
	public Game createGame() {
		Game game = new ConnectFour();
		return game;
	}
	
	public ConnectFourGraphical() {
		Game game = createGame();
	}
}
