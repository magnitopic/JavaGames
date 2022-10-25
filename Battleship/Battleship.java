package Battleship;

import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		String[][] tableroAlianza = new String[10][10];
		String[][] tableroImperio = new String[10][10];
		int opt;

		// pedir que tipo de juego
		do {
			System.out.println("Tipo de partida:");
			System.out.println("1. Un jugador");
			System.out.println("2. Dos jugadores");
			System.out.print("--> ");
			opt = sc.nextInt();
		} while (opt != 1 && opt != 2);

		// Pedir posiciones de naves
		int x, y;
		String opt2;

		// user 1
		do {
			System.out.println("Jugador 1, quieres general la posición de las naves de manera aleatoria?(y,n)");
			System.out.print("--> ");
			opt2 = sn.nextLine();
		} while (!opt2.equalsIgnoreCase("y") && !opt2.equalsIgnoreCase("n"));

		if (opt2.equalsIgnoreCase("n")) {
			for (int j = 0; j < 6; j++) {
				do {
					System.out.print("Introduce la posición X de la nave " + (j + 1) + ": ");
					x = sc.nextInt();
					System.out.print("Introduce la posición Y de la nave " + (j + 1) + ": ");
					y = sc.nextInt();
				} while (!(x <= 9 && x >= 0 && y <= 9 && y >= 0) || tableroAlianza[x][y] == "H");
				tableroAlianza[x][y] = "H";
			}
		} else
			randomTable(tableroAlianza);

		// user 2
		if (opt == 2) {
			do {
				System.out.println("Jugador 2, quieres general la posición de las naves de manera aleatoria?(y,n)");
				System.out.print("--> ");
				opt2 = sn.nextLine();
			} while (!opt2.equalsIgnoreCase("y") && !opt2.equalsIgnoreCase("n"));

			if (opt2.equalsIgnoreCase("n")) {
				for (int j = 0; j < 6; j++) {
					do {
						System.out.print("Introduce la posición X de la nave " + (j + 1) + ": ");
						x = sc.nextInt();
						System.out.print("Introduce la posición Y de la nave " + (j + 1) + ": ");
						y = sc.nextInt();
					} while (!(x <= 9 && x >= 0 && y <= 9 && y >= 0) || tableroImperio[x][y] == "H");
					tableroImperio[x][y] = "H";
				}
			} else
				randomTable(tableroImperio);
		} else
			randomTable(tableroImperio);

		// gameplay

		while (true) {
			// player 1
			System.out.print("\033[H\033[2J");
			System.out.println("Player 1's turn.");
			printBoard(tableroAlianza, "Your board");
			printBoardFull(tableroImperio, "Enemy board");
			makeLauch(tableroImperio, sc);
			if (checkGameEnd(tableroImperio)) {
				System.out.println("Player 1 wins!!!");
				break;
			}

			// player 2
			System.out.print("\033[H\033[2J");
			System.out.println("Player 2's turn.");
			printBoard(tableroImperio, "Your board");
			printBoardFull(tableroAlianza, "Enemy board");
			if (checkGameEnd(tableroAlianza)) {
				System.out.println("Player 2 wins!!!");
				break;
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

	public static void makeLauch(String[][] board, Scanner sc) {
		int x, y;
		boolean flag = false;
		do {
			flag = false;
			do {
				System.out.print("Intoduce la cordenada X donde se quiere hacer un lanzamiento: ");
				x = sc.nextInt();
				System.out.print("Intoduce la cordenada Y donde se quiere hacer un lanzamiento: ");
				y = sc.nextInt();
			} while (!(x <= 9 && x >= 0 && y <= 9 && y >= 0));

			if (board[x][y] != null) {
				if (board[x][y].equalsIgnoreCase("h")) {
					System.out.println("Nave destruida!!");
					board[x][y] = "X";
				} else if (board[x][y].equalsIgnoreCase("a")) {
					flag = true;
					System.out.println("Esta posición ya ha sido atacada.");
				} else if (board[x][y].equalsIgnoreCase("x")) {
					flag = true;
					System.out.println("Esta nave ya ha sido destruida.");
				}
			} else {
				System.out.println("No hay nada en esta posición");
				board[x][y] = "A";
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
		for (int j = 0; j < board.length * 2 + 1; j++)
			System.out.print("- ");

		System.out.print("\n");
		for (int i = 0; i < name.length(); i++)
			System.out.print("    " + name.charAt(i));

		System.out.print("\n");
		for (int j = 0; j < board.length * 2 + 1; j++)
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
		for (int j = 0; j < board.length * 2 + 1; j++)
			System.out.print("- ");

		System.out.print("\n");
		for (int i = 0; i < name.length(); i++)
			System.out.print("    " + name.charAt(i));

		System.out.print("\n");
		for (int j = 0; j < board.length * 2 + 1; j++)
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
				else if (board[i][j].equalsIgnoreCase("h"))
					System.out.print("| " + board[i][j] + " ");
				else
					System.out.print("|   ");

			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
