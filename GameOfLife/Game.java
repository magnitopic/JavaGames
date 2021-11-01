package GameOfLife;

import java.util.ArrayList;
import static java.util.concurrent.TimeUnit.*;
import java.lang.Math;
import java.util.Scanner;

public class Game {
	public ArrayList<ArrayList<Cell>> board;

	public Game() {
		this.board = new ArrayList<ArrayList<Cell>>();
	}

	public void newGame() {
		// Creates the Cell objects and adds them to the board matrix
		for (int i = 0; i <= 29; i++) {
			ArrayList<Cell> row = new ArrayList<Cell>();
			for (int j = 0; j <= 29; j++) {
				Cell cell = new Cell(false, i, j);
				row.add(cell);
			}
			this.board.add(row);
		}
		// We also set the neighbours of the objects since this is only ruined the first
		// time
		setNeighbours();
	}

	public void setNeighbours() {
		// Gives all the Cell objects the board matrix so they can find their neighbours
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board.get(0).size(); j++) {
				board.get(i).get(j).getNeighbours(this.board);
			}
		}
	}

	public void randomCells(int cells) {
		// Generates random alive cells
		for (int j = 0; j < cells; j++) {
			int randomX = (int) (Math.random() * (30));
			int randomY = (int) (Math.random() * (30));
			board.get(randomX).get(randomY).alive = true;
		}
	}

	public void printBoard() {
		// Goes through the Cells in the matrix and prints if they are alive (with ■) or
		// if they are dead (with □)
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
		System.out.println("____________________");
	}

	public void newGeneration() {
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board.get(0).size(); j++) {
				board.get(i).get(j).newGeneration();
			}
		}
		printBoard();
	}

	// Test method that let's you see any cells neighbours
	/*
	 * public void test() { Cell testCell = board.get(14).get(14);
	 * 
	 * for (int i = 0; i < testCell.neighbours.size(); i++) {
	 * testCell.neighbours.get(i).alive = true; } }
	 */

	// I have no idea why throws InterruptedException works and prevents sleep from
	// giving us an error. Learned it from this wonderful video by The Whiz.
	// https://youtu.be/sE6ksxK3oEg
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		game.newGame();
		System.out.println("-------------------");
		System.out.println("Wellcome to the game of life!");
		System.out.println("");
		System.out.println("This is a 0 player game. It is composed of a 30X30 matirx of alive or dead cells.");
		System.out.println("Each turn, rules will aplay to all cells (refer to Rules.png).");
		System.out.println("And the result will be printed on the terminal.");
		System.out.println("Alive cells will be represented as ■. And dead cells will be represented with □.");
		System.out.println("");
		System.out.println("1. Input initial alive cells.");
		System.out.println("2. Generate random alive cells.");
		System.out.println("-------------------");

		int response = game.isInputInt(scanner);
		if (response == 1) {
			System.out.println("I'll ask for a X and Y coordinates. The cell in that positio will be alive.");
			System.out.println("Remember to use numbers between 0 and 29.");
			System.out.println("To quit type exit or q.");
			System.out.println("-------------------");
			while (true) {
				System.out.println("Give me a value for X. Or exit.");
				boolean isAnInt = scanner.hasNextInt();
				if (isAnInt) {
					int Xvalue = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Give me a value for Y.");
					int Yvalue = game.isInputInt(scanner);
					game.board.get(Xvalue).get(Yvalue).alive = true;
				} else {
					String value = scanner.nextLine().toLowerCase();
					if (value.equals("exit") || value.equals("q")) {
						break;
					} else {
						System.out.println("Invalid input. Try again.");
						scanner.nextLine();
					}
				}
			}
		} else if (response == 2) {
			System.out.println("How many random cells do you want to generate?");
			game.randomCells(game.isInputInt(scanner));
		}
		scanner.close();
		while (true) {
			game.newGeneration();
			// This means that the output of the terminal will be re-done every second
			Thread.sleep(1000);
		}

	}

	// This function checks that the user input is a number and will ask until it
	// gets one. Made it to simplify the code that deals with the user.
	public int isInputInt(Scanner scanner) {
		while (true) {
			boolean isAnInt = scanner.hasNextInt();
			if (isAnInt) {
				int value = scanner.nextInt();
				scanner.nextLine();
				return value;
			} else {
				System.out.println("Invalid input. Try again.");
				scanner.nextLine();
			}
		}
	}

}