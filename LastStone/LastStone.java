package LastStone;

import java.util.Scanner;

public class LastStone {
	private boolean playing=true;
	private int number;
	private int userChoice;
	private int machineChoice;

	private void generateNumber() {
		number = (int) (Math.random() * 10) + 16;
	}

	private void getUserChoice(Scanner scanner) {
		while (true) {
			System.out.println(this.number+" stones remain.");
			System.out.print("Would you like to remove 1, 2 or 3?: ");
			userChoice = scanner.nextInt();
			if (userChoice > 0 && userChoice < 4) {
				break;
			} else {
				System.out.println("Your input was not valid. Try again.");
			}
		}
		number=number-userChoice;
		if(number<=0){
			System.out.println("The machine wins...");
			playing=false;
		}
	}

	private void generateMachineChoice(){
		int m=(number-1)%4;
		if(m==0){
			m=((int)(Math.random()*3)+1);
		}
		this.machineChoice=m;
		number=number-machineChoice;
		if(number<=0&&playing){
			System.out.println("You win!!");
			playing=false;
		}
	}

	public void playGame(){
		Scanner scanner = new Scanner(System.in);
		generateNumber();
		System.out.println("HOW TO PLAY:");
		System.out.println("There are "+this.number+" stones this round, you will have to take 1, 2 or 3 in each round.");
		System.out.println("The player that takes the final stone loses.");
		System.out.println("");
		while(playing){
			getUserChoice(scanner);
			generateMachineChoice();
		}
	}

	public static void main(String[] args) {
		LastStone lastStone = new LastStone();
		lastStone.playGame();
	}
}
