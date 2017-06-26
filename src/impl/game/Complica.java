package impl.game;

import api.Chip;
import exc.IllegalMoveException;

public class Complica extends Template {

	public Complica() {
		super(7, 4);
		
	}

	@Override
	void place(int col)  {
		if (board[0][col].isEmpty() == true) {
			// if there is still space, simply put the chip down
			for (int r = this.getRows() - 1; r >= 0; r--){
				
				if (this.board[r][col].isEmpty()){
					this.board[r][col] = this.getCurrentPlayer();
					setChanged();
					break;
				} 
			}
		} else {
			// if there is no space, shift everything down
			for (int r = this.getRows() - 1; r > 0; r--){
					this.board[r][col] = this.board[r-1][col];		
			}
			this.board[0][col] = this.getCurrentPlayer();
			setChanged();
		}
		
	}

	

	public boolean isGameActuallyOver(int redScore, int blueScore) {
		// TODO Auto-generated method stub
		if (blueScore > redScore) {
			winner = Chip.BLUE;
			System.out.println("blue winsssss");
			return true;
		} else if (blueScore < redScore) {
			winner = Chip.RED;
			System.out.println("red winsss");
			return true;
		} else {
			return false;
		}
	}
	
	
	
}