package impl.view;

import api.Game;
import impl.game.Complica;

public class ComplicaGraphical extends Graphical {
	@Override
	public Game createGame() {
		Game game = new Complica();
		return game;
	}
	
	public ComplicaGraphical() {
		Game game = createGame();
	}
}
