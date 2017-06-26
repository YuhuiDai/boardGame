package test.system;

public class GameTest {

	public static void main(String[] args) {
		System.out.println(args[0]);
		
		switch (args[1]) {
    	case "console":
    		ConsoleTest.main(args[0]);
    		break;
    	case "graphical":
    		GraphicalViewTest.main(args[0]);
    		break;
    	default:
    		System.err.println("Invalid Arguments");
    		break;
    }

	}

}
