package Battleship;

import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		String[][] player1Board = new String[10][10];
		String[][] player2Board = new String[10][10];
		int opt;

		System.out.print("\033[H\033[2J");
		// pedir que tipo de juego
		do {
			System.out.println("Type of game:");
			System.out.println("1. Single player");
			System.out.println("2. Two players");
			System.out.print("--> ");
			opt = sc.nextInt();
		} while (opt != 1 && opt != 2);

		// Pedir posiciones de naves
		int x, y;
		String opt2;

		// user 1
		do {
			System.out.println("Player 1, would you like your ships to be placed randomly?(y,n)");
			System.out.print("--> ");
			opt2 = sn.nextLine();
		} while (!opt2.equalsIgnoreCase("y") && !opt2.equalsIgnoreCase("n"));

		if (opt2.equalsIgnoreCase("n")) {
			for (int j = 0; j < 6; j++) {
				do {
					System.out.print("Enter the X coordinate you want for ship " + (j + 1) + ": ");
					x = sc.nextInt();
					System.out.print("Enter the Y coordinate you want for ship " + (j + 1) + ": ");
					y = sc.nextInt();
				} while (!(x <= 9 && x >= 0 && y <= 9 && y >= 0) || player1Board[x][y] == "H");
				player1Board[x][y] = "H";
			}
		} else
			randomTable(player1Board);

		// user 2
		if (opt == 2) {
			do {
				System.out.println("Player 2, would you like your ships to be placed randomly?(y,n)");
				System.out.print("--> ");
				opt2 = sn.nextLine();
			} while (!opt2.equalsIgnoreCase("y") && !opt2.equalsIgnoreCase("n"));

			if (opt2.equalsIgnoreCase("n")) {
				for (int j = 0; j < 6; j++) {
					do {
						System.out.print("Enter the X coordinate you want for ship " + (j + 1) + ": ");
						x = sc.nextInt();
						System.out.print("Enter the Y coordinate you want for ship " + (j + 1) + ": ");
						y = sc.nextInt();
					} while (!(x <= 9 && x >= 0 && y <= 9 && y >= 0) || player2Board[x][y] == "H");
					player2Board[x][y] = "H";
				}
			} else
				randomTable(player2Board);
		} else
			randomTable(player2Board);

		// gameplay

		while (true) {
			// player 1
			System.out.print("\033[H\033[2J");
			System.out.println("Player 1's turn.\n");
			printBoardFull(player1Board, "Your board");
			printBoard(player2Board, "Enemy board");
			makeLauch(player2Board, sc);
			if (checkGameEnd(player2Board)) {
				System.out.println("Player 1 wins!!!");
				break;
			}
			System.out.println("Press enter to continue.");
			sn.nextLine();

			// player 2
			if (opt == 2) {
				System.out.print("\033[H\033[2J");
				System.out.println("Player 2's turn.\n");
				printBoardFull(player2Board, "Your board");
				printBoard(player1Board, "Enemy board");
				makeLauch(player1Board, sc);
				if (checkGameEnd(player1Board)) {
					System.out.println("Player 2 wins!!!");
					break;
				}
				System.out.println("Press enter to continue.");
				sn.nextLine();
			} else {
				makeLaunchIA(player1Board);
			}
		}

		sc.close();
		sn.close();
	}

	public static boolean checkGameEnd(String[][] board) {
		// if no H exist in the matrix, all ships are destroyed and the game is over
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != null && board[i][j].equalsIgnoreCase("h"))
					return false;
			}
		}
		return true;
	}

	public static void makeLaunchIA(String[][] board) {
		int x, y;
		boolean flag = false;

		do {
			x = (int) (Math.random() * 10);
			y = (int) (Math.random() * 10);
			flag = false;
			if (board[y][x] != null) {
				if (board[y][x].equalsIgnoreCase("h"))
					board[y][x] = "X";
				else
					flag = true;
			} else
				board[y][x] = "•";
		} while (flag);

	}

	public static void makeLauch(String[][] board, Scanner sc) {
		int x, y;
		boolean flag = false;
		do {
			flag = false;
			do {
				System.out.print("Enter the X coordinate you wish to attack: ");
				x = sc.nextInt();
				System.out.print("Enter the Y coordinate you wish to attack: ");
				y = sc.nextInt();
			} while (!(x <= 9 && x >= 0 && y <= 9 && y >= 0));

			if (board[y][x] != null) {
				if (board[y][x].equalsIgnoreCase("h")) {
					System.out.println("\nWe have hit and sunk a battleship!!!\n");
					board[y][x] = "X";
				} else if (board[y][x].equalsIgnoreCase("•")) {
					flag = true;
					System.out.println("\nThis possition has already been ataked...\n");
				} else if (board[y][x].equalsIgnoreCase("x")) {
					flag = true;
					System.out.println("\nThis battleship is alredy sunk...\n");
				}
			} else {
				System.out.println("\nNothing was hit in this possition.\n");
				board[y][x] = "•";
			}
		} while (flag);
	}

	public static void randomTable(String[][] board) {
		int i = 0;
		int x, y;
		while (i < 6) {
			x = (int) (Math.random() * 10);
			y = (int) (Math.random() * 10);
			if (board[x][y] != "H") {
				board[x][y] = "H";
				i++;
			}
		}
	}

	public static void printBoardFull(String[][] board, String name) {
		for (int j = 0; j < board.length * 2 + 4; j++)
			System.out.print("- ");

		System.out.print("\n");
		for (int i = 0; i < name.length(); i++)
			System.out.print("   " + name.charAt(i));

		System.out.print("\n");
		for (int j = 0; j < board.length * 2 + 4; j++)
			System.out.print("- ");

		System.out.print("\n ");
		for (int i = 0; i < 10; i++)
			System.out.print("   " + i);
		System.out.print("\n");
		for (int i = 0; i < board.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null)
					System.out.print("|   ");
				else
					System.out.print("| " + board[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void printBoard(String[][] board, String name) {
		for (int j = 0; j < board.length * 2 + 4; j++)
			System.out.print("- ");

		System.out.print("\n");
		for (int i = 0; i < name.length(); i++)
			System.out.print("   " + name.charAt(i));

		System.out.print("\n");
		for (int j = 0; j < board.length * 2 + 4; j++)
			System.out.print("- ");

		System.out.print("\n ");
		for (int i = 0; i < 10; i++)
			System.out.print("   " + i);
		System.out.print("\n");
		for (int i = 0; i < board.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null)
					System.out.print("|   ");
				else if (!board[i][j].equalsIgnoreCase("h"))
					System.out.print("| " + board[i][j] + " ");
				else
					System.out.print("|   ");

			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
