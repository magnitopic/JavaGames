package GameOfLife;

import java.util.ArrayList;

public class Game{
	public ArrayList<ArrayList<Cell>> board;
	
	public Game() {
		this.board=new ArrayList<ArrayList<Cell>>();
	}
	
	public void newGame() {
		for(int i=0;i<29;i++){
			ArrayList<Cell> row=new ArrayList<Cell>();
			for(int j=0;j<29;j++){
				Cell cell=new Cell(false,i,j);
				row.add(cell);
			}
			this.board.add(row);
		}
	}

	public void printBoard() {
		for(int i=0;i<29;i++){
			System.out.println("");
			for(int j=0;j<29;j++){
				if(board.get(i).get(j).alive){
					System.out.print(" ■ ");
				}else{
					System.out.print(" □ ");
				}
			}
		}
	}

	public void test() {
		/* board.get(5).get(5).getNeighbours(board); */
	}

	public static void main(String[] args) {
		Game game=new Game();
		game.newGame();
		game.printBoard();
	}
}