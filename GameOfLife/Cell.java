package GameOfLife;

import java.util.ArrayList;

public class Cell {
	public boolean alive;
	public int x;
	public int y;
	public ArrayList<Cell> neighbours;

	public Cell(boolean alive, int x, int y) {
		this.alive = alive;
		this.x = x;
		this.y = y;
		this.neighbours = new ArrayList<Cell>();
	}

	public void getNeighbours(ArrayList<ArrayList<Cell>> board) {
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board.get(0).size(); j++) {
				if ((board.get(i).get(j).x == this.x) || (board.get(i).get(j).x == (this.x - 1))
						|| (board.get(i).get(j).x == (this.x + 1))) {
					if ((board.get(i).get(j).y == (this.y - 1)) || (board.get(i).get(j).y == (this.y + 1))
					// I have to make sure I don't add this cell, only it's neighbours
					// So I make sure that both X and Y aren't the same
							|| ((board.get(i).get(j).y == this.y) && (board.get(i).get(j).x != this.x))) {
						this.neighbours.add(board.get(i).get(j));
					}
				}
			}
		}
	}

	public void newGeneration() {
		// Goes over the rules to determine if it should be dead or alive
		// (see Rules.png for referance)
		int counter = 0;
		for (int i = 0; i < neighbours.size(); i++) {
			if (neighbours.get(i).alive) {
				counter++;
			}
		}
		if (counter < 2 || counter < 3) {
			this.alive = false;
		} else if (counter == 3) {
			this.alive = true;
		}
	}
}