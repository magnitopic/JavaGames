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

		printBoard(tableroImperio, "Imperio");
		printBoard(tableroAlianza, "Alianza");

		sc.close();
		sn.close();
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

	public static void printBoard(String[][] board, String name) {
		String[] letrasTablero = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
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
			System.out.print(" | " + i);
		System.out.print("\n");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length * 2 + 1; j++)
				System.out.print("- ");
			System.out.print("\n");
			System.out.print(letrasTablero[i] + " ");
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null)
					System.out.print("| 0 ");
				else
					System.out.print("| " + board[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
