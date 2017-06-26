package impl.game;

import api.Chip;
import api.Game;
import exc.GameStateException;
import exc.IllegalMoveException;

public abstract class Template extends Game {
	public Chip[][] board;
	public Chip player = Chip.EMPTY;
	public Chip winner = Chip.EMPTY;
	
	public Template(int row, int col) {
		// initialize the playing board
		board = new Chip[row][col];
		for (int r=0; r<this.board.length; r++){
			for (int c=0; c < this.board[0].length; c++) {
				board[r][c] = Chip.EMPTY;
			}
		}
		//set the first player to be red
		this.player = Chip.RED;
	}
	
	@Override
	public int getRows() {
		//ask for rows of players
		return this.board.length;
	}

	@Override
	public int getColumns() {
		return this.board[0].length;
	}

	@Override
	public Chip[][] getBoard() {
		return board;
	}
	
	public void setPlayer() {
		if (this.isGameOver()!= true) {
			if (this.player == Chip.BLUE) {
	            this.player = Chip.RED;
	        } else if (this.player == Chip.RED) {
	            this.player = Chip.BLUE;
	        }
		}
	}
	
	abstract void place(int col) throws IllegalMoveException;
	
 	public void placeDisk(int row, int col) throws GameStateException, IllegalMoveException {
 	
 			if (isGameOver()) {
 				throw new GameStateException();
 			}
 			//sanity check
 			if (col > this.getColumns() - 1 || col < 0){
 				throw new IllegalMoveException();
 			}
 			if (row > this.getRows() - 1 || row < 0){
 				throw new IllegalMoveException();
 			}
 			
 			
 			place(col);
 			setPlayer();
 			notifyObservers();
 	}
 	
 	@Override
	public Chip getWinningPlayer() throws GameStateException {
		if (this.winner == Chip.EMPTY){
			throw new GameStateException();
		}
		return this.winner;
	}

	@Override
	public Chip getCurrentPlayer() {
		return this.player;
	}
	
	public abstract boolean isGameActuallyOver(int redScore, int blueScore);
	public boolean isGameOver() {
		int redScore = 0;
		int blueScore = 0;
		//check horizontal
		for (int r=0; r<this.board.length; r++){
			for (int c=0; c < this.board[0].length-3; c++) {
				if (this.board[r][c].isEmpty() != true && this.board[r][c] == this.board[r][c+1] && this.board[r][c+1] == this.board[r][c+2] && this.board[r][c+2] == board[r][c+3] ) {
					if (this.board[r][c] == Chip.BLUE) {
						
						blueScore ++;
						System.out.println("blue horizontal" + blueScore);
					} else if (this.board[r][c] == Chip.RED) {
						
						redScore ++;
						System.out.println("red horizontal" + redScore);
					}
						
				}	
			}
		}

				//check vertical
				for (int c=0; c<this.board[0].length; c++){
					for (int r=0; r <this.board.length-3; r++) {
						if (this.board[r][c].isEmpty() != true && this.board[r][c] == this.board[r+1][c] && this.board[r+1][c] == this.board[r+2][c] && this.board[r+3][c] == this.board[r+2][c]) {
							if (this.board[r][c] == Chip.BLUE) {
								blueScore ++;
								System.out.println("blue vertical" + blueScore);
							} else if (this.board[r][c] == Chip.RED) {
								redScore ++;
								System.out.println("red vertical" +redScore);
							}
						}	
					}
				}
			

				//check down diagonal
				for (int r=0; r <this.board.length-3; r++){
					for (int c=0; c<this.board[0].length-3; c++) {
						if (this.board[r][c].isEmpty() != true && this.board[r][c] == this.board[r+1][c+1] && this.board[r+2][c+2] == this.board[r+1][c+1] && this.board[r+3][c+3] == this.board[r+2][c+2]) {
							if (this.board[r][c] == Chip.BLUE) {
								
								blueScore ++;
								System.out.println("blue down" + blueScore);
							} else if (this.board[r][c] == Chip.RED) {
								redScore ++;
								System.out.println("REd down" + redScore);
							}
						}	
					}
				}
				

				//check up diagonal
				for (int r=this.board.length-3; r<this.board.length; r++){
					for (int c=0; c<this.board[0].length-3; c++) {
						if (this.board[r][c].isEmpty() != true && this.board[r][c] == this.board[r-1][c+1] && this.board[r-2][c+2]== this.board[r-1][c+1] && this.board[r-3][c+3] == this.board[r-2][c+2]) {
							if (this.board[r][c] == Chip.BLUE) {
								blueScore ++;
								
							} else if (this.board[r][c] == Chip.RED) {
								redScore ++;
								System.out.println("red up" + redScore);
							}
						}	
					}
				}
				
				return isGameActuallyOver(redScore, blueScore);
	}

}
