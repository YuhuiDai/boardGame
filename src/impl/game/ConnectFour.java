package impl.game;
import api.Chip;
import exc.IllegalMoveException;

public class ConnectFour extends Template {
	
	public ConnectFour() {
		super(6,7);
		// TODO Auto-generated constructor stub
	}
	
	
	public void place(int col) throws IllegalMoveException {
		// check if column full
		if (board[0][col].isEmpty() == false) {
				throw new IllegalMoveException();
		}
			
		for (int r = this.getRows() - 1; r >= 0; r--){
				//reverse check
				if (this.board[r][col].isEmpty()){
					this.board[r][col] = this.getCurrentPlayer();
					setChanged();
					break;
				} 
			
		}
	}


	@Override
	public boolean isGameActuallyOver(int redScore, int blueScore) {
		
		if (blueScore > redScore) {
			winner = Chip.BLUE;
			System.out.println("blue winsssss");
			return true;
		} else if (blueScore < redScore) {
			winner = Chip.RED;
			System.out.println("red winsss");
			return true;
		} else {
			//check whether it is full, if not still game on, if yes continue
			for (int r = 0; r < this.board.length; r++) {
				for (int c = 0; c < this.board[0].length; c++) {
					if (this.board[r][c].isEmpty() == true){
						return false;
					}
				}
			}
			// if it is full, and we have no winner, then it is a tie
			player = Chip.EMPTY;
			return true;
		}
	}

	
}