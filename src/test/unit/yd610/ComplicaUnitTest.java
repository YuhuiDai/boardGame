package test.unit.yd610;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import api.Chip;
import api.Game;
import exc.GameStateException;
import exc.IllegalMoveException;
import impl.game.Complica;

public class ComplicaUnitTest {
	Game game = new Complica();
	
	@Test
    public void testInitSetsPlayer() {
        Chip chip = game.getCurrentPlayer();
	assertFalse(chip.isEmpty());
    }
	
	@Test
    public void testInitBlanksBoard() {
        Chip[][] surface = game.getBoard();

        for (int row = 0; row < game.getRows(); row++) {
            for (int col = 0; col < game.getColumns(); col++) {
                Chip chip = surface[row][col];
                assertTrue(chip.isEmpty());
            }
        }
    }
	@Test
    public void testInitSetsRows() {
        assertEquals(game.getRows(), 7);
    }

    @Test
    public void testInitSetsColumns() {
        assertEquals(game.getColumns(), 4);
    }

	@Test 
	public void diangonalWinTest1() throws GameStateException, IllegalMoveException {
		
		int order[] = {0,1,1,2,2,3,2,3,3,0,3};
		for (int i=0;i<order.length;i++){
			game.placeDisk(order[i]);
		}
		assertTrue(game.isGameOver());
	}

	@Test
	public void diangonalWinTest2() throws GameStateException, IllegalMoveException {
		
		int order[] = {0,0,0,0,1,1,2,1,1,2,1,3};
		for (int i=0;i<order.length;i++){
			game.placeDisk(order[i]);
		}
		assertTrue(game.isGameOver());
	}

	@Test
	public void horizontalWinTest() throws GameStateException, IllegalMoveException {

		int order[] = {0,0,1,1,2,2,3};
		for (int i=0;i<order.length;i++){
			game.placeDisk(order[i]);
		}
		assertTrue(game.isGameOver());
	}

	@Test
	public void connectFourVerticalWinTest() throws GameStateException, IllegalMoveException {
		int order[] = {0,1,0,1,0,1,0};
		for (int i=0;i<order.length;i++){
			game.placeDisk(order[i]);
		}
		assertTrue(game.isGameOver());
	}

	@Test
	public void emptyBoardTest() {

		for (int i=0;i<game.getRows();i++){
			for (int j=0;j<game.getColumns();j++){
				Chip chip = game.getBoard()[i][j];
				assertEquals(chip, Chip.EMPTY);
			}
		}
	}

	@Test(expected = IllegalMoveException.class)
	public void outOfBoundsRight() throws GameStateException, IllegalMoveException {

		game.placeDisk(7);		
	}

	@Test(expected = IllegalMoveException.class)
	public void outofBoundsLeftTest() throws GameStateException, IllegalMoveException {
		game.placeDisk(-1);			
	}


	@Test
	public void alternatePlayerStartTest() throws GameStateException, IllegalMoveException {
		Chip chip = game.getCurrentPlayer();
		game.placeDisk(1);
		assertNotEquals(chip, game.getCurrentPlayer());
	}
	
	@Test
	public void tieGamePlayerChange() {
		
	}
	

}
