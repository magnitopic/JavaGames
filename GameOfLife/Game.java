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
}