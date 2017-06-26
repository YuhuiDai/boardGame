package test.system;

import api.View;

import java.util.Scanner;

import api.Chip;
import api.Game;
import exc.GameStateException;
import exc.IllegalMoveException;
import impl.view.ComplicaGraphical;
import impl.view.ConnectFourGraphical;
import impl.view.Console;
import javafx.application.Application;
import impl.game.Complica;
import impl.game.ConnectFour;

public class ConsoleTest {
    public static void main(String args) {
    Game game = null;
	System.out.println(args);
    
    switch (args) {
    	case "connectfour":
    		game = new ConnectFour();
    		break;
    	case "complica":
    		game = new Complica();
    		break;
    	default:
    		System.err.println("Invalid Arguments");
    		break;
    }
    
	View view = new Console(game);
	view.update(game);
	
	try {
	    Chip winner = game.getWinningPlayer();
	    System.out.println(winner + " wins!");
	}
	catch (GameStateException e) {
	    System.out.println("It was a tie!");
	}
    }
    
}
