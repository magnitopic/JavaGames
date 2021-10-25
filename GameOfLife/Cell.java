package GameOfLife;

import java.util.ArrayList;

public class Cell{
  public boolean alive;
  public int x;
  public int y;
  public ArrayList<Cell> neighbours;

  public Cell(boolean alive, int x, int y) {
    this.alive = alive;
    this.x = x;
    this.y = y;
  }

  public void getNeighbours(ArrayList<ArrayList<Cell>> board) {
    for(int i=0;i<29;i++){
			for(int j=0;j<29;j++){
        switch(board.get(i).get(j).x){
          case x:
            switch(board.get(i).get(j).y){
              case y-1:
                neighbours.add(board.get(i).get(j));
              break;
              case y+1:
                neighbours.add(board.get(i).get(j));
              break;
            }
          break;
          case x-1:
            switch(board.get(i).get(j).y){
              case y:
                neighbours.add(board.get(i).get(j));
              break;
              case y-1:
                neighbours.add(board.get(i).get(j));
              break;
              case y+1:
                neighbours.add(board.get(i).get(j));
              break;
            }
          break;
          case x+1:
            switch(board.get(i).get(j).y){
              case y:
                neighbours.add(board.get(i).get(j));
              break;
              case y-1:
                neighbours.add(board.get(i).get(j));
              break;
              case y+1:
                neighbours.add(board.get(i).get(j));
              break;
            }
          break;
        }
			}
		}
  }

  public void newGeneration() {

  }
}