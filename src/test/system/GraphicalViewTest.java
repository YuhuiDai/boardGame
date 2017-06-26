package test.system;

import impl.view.ComplicaGraphical;
import impl.view.ConnectFourGraphical;
import impl.view.Graphical;
import javafx.application.Application;

public class GraphicalViewTest {
    public static void main(String args) {

        System.out.println(args);
        
        switch (args) {
        	case "connectfour":
        		Application.launch(ConnectFourGraphical.class);
        		break;
        	case "complica":
        		Application.launch(ComplicaGraphical.class);
        		break;
        	default:
        		System.err.println("Invalid Arguments");
        		break;
        }
    }
}
