package GameOfLife;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Game {
	public ArrayList<ArrayList<Cell>> board;

	public Game() {
		this.board = new ArrayList<ArrayList<Cell>>();
	}

	public void newGame() {
		for (int i = 0; i < 29; i++) {
			ArrayList<Cell> row = new ArrayList<Cell>();
			for (int j = 0; j < 29; j++) {
				Cell cell = new Cell(false, i, j);
				row.add(cell);
			}
			this.board.add(row);
		}
		setNeighbours();
	}

	public void setNeighbours() {
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board.get(0).size(); j++) {
				board.get(i).get(j).getNeighbours(this.board);
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < board.size(); i++) {
			System.out.println("");
			for (int j = 0; j < board.get(0).size(); j++) {
				if (board.get(i).get(j).alive) {
					System.out.print(" ■ ");
				} else {
					System.out.print(" □ ");
				}
			}
		}
		System.out.println("");
		System.out.print("____________________");
	}

	public void newGeneration() {
		
	}


	//Test method that let's you see any 
	public void test() {
		Cell testCell=board.get(14).get(14);

		for(int i=0;i<testCell.neighbours.size();i++){
			testCell.neighbours.get(i).alive=true;
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.newGame();
		game.printBoard();
		game.test();
		game.printBoard();
	}
}