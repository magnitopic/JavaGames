package GameOfLife;

import java.util.ArrayList;

public class Cell{
	public boolean alive;
	public int id;

	public Cell N;
	public Cell S;
	public Cell E;
	public Cell W;
	public Cell NE;
	public Cell NW;
	public Cell SE;
	public Cell SW;
  public ArrayList neighbours<Cell>;

  public void firstGeneration(){
    this.neighbours=new ArrayList<Cell>();
    neighbours.add(N);
    neighbours.add(S);
    neighbours.add(E);
    neighbours.add(W);
    neighbours.add(NE);
    neighbours.add(NW);
    neighbours.add(SE);
    neighbours.add(SW);
    newGeneration();
  }

	public void newGeneration() {
		for(int i=0; i<7;i++){
      
    }
	}

  public static void main(String[] args) {
		Cell cell=new Cell();
    cell.newGeneration();
    System.out.print(cell.num);
	}
}