package GuessTheNumber;

import java.util.Scanner;

public class GuessTheNumber {
	private int number;
	private int guess;
	private int trys;

	public GuessTheNumber() {
		this.number = generateNumber();
	}

	private int generateNumber() {
		return ((int) (Math.random() * 101));
	}

	private void userInput(Scanner input) {
		System.out.print("Try and guess the number: ");
		while (true) {
			this.guess = input.nextInt();
			if (this.guess >= 0 && this.guess <= 100) {
				break;
			} else {
				System.out.println("Your input was not valid. Try again.");
			}
		}
	}

	public void playGame() {
		Scanner input = new Scanner(System.in);
		System.out.println(
				"A number between 0 and 100 has been chosen at random, you'll have to guess which one it is. Good luck!");
		while (number != guess) {
			userInput(input);
			trys++;
			if (this.guess > this.number) {
				System.out.println("The number is smaller than "+this.guess);
			}else if(this.guess<this.number){
				System.out.println("The number is biger than "+this.guess);
			}
		}
		System.out.println("_____________________________________________");
		System.out.println("You correctly guessed the number was "+this.number);
		System.out.println("And it only took you "+this.trys+" trys!");
	}

	public static void main(String[] args) {
		GuessTheNumber a = new GuessTheNumber();
		a.playGame();
	}
}