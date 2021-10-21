package GameOfLife;

import java.util.ArrayList;

public class Cell{
	public boolean alive;
	public int x;
  public int y;

  public Cell(boolean alive, int x, int y) {
    this.alive = alive;
    this.x = x;
    this.y = y;
  }


	public void newGeneration() {
		/* for(int i=0; i<7;i++){
      
    } */
	}

  public static void main(String[] args) {
		Cell cell=new Cell();
    cell.newGeneration();
    System.out.print(cell.num);
	}
}