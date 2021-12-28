package BullsAndCows;

import java.util.Scanner;
import java.util.ArrayList;

public class BullsAndCows {
	private int trys;
	public ArrayList<Integer> num;
	private ArrayList<Integer> userNum;

	public BullsAndCows() {
		this.trys = 15;
		this.num = new ArrayList<Integer>();
		int i = 0;
		// Generates 4 dieferent Integers for num
		while (i < 4) {
			int rnd = (int) (Math.random() * 10);
			boolean diferent = true;

			for (int j = 0; j < num.size(); j++) {
				if (num.get(j) == rnd) {
					diferent = false;
				}
			}
			if (diferent) {
				i++;
				this.num.add(rnd);
			}
		}
	}

	public void turn(Scanner scanner) {
		System.out.println("Give me a number with four diferent digits: ");
		isInputInt(scanner);
	}

	// This function checks that the user input is a number and will ask until it
	// gets one. Made it to simplify the code that deals with the user.
	// I added the condition that the number has to have 4 unique digits
	public void isInputInt(Scanner scanner) {
		while (true) {
			String input = scanner.nextLine();
			if (input.length() > 4 && input.length() < 4) {

			}
		}
	}

	public void startGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("============= BullsAndCows Game =============");
		System.out.println("I'm thinking of four diferent digits from cero to nine, bouth included.");
		System.out.println("If you correctlly guess the value of a digit but not it's position it will be counted Cow");
		System.out.println("If you guess bouth the digits value and it's position it will be counted as Bull.");
		System.out.println("You must get four Bulls to win and you have 15 trys. Good luck.");
		System.out.println("==========================");
		boolean playing=true;
		while(playing){
			turn(scanner);
			trys--;
			if(trys<=0){
				System.out.println("You have run out of trys. You lose.");
				playing=false;
			}else if(){
				System.out.println("You win! You guessed "+num.get(0)+num.get(1)+num.get(2)+num.get(3)+" in "+this.trys+" trys.");
				playing=false;
			}
		}
	}

	public static void main(String[] args) {
		BullsAndCows dead = new BullsAndCows();

	}

}
