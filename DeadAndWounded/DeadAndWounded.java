package DeadAndWounded;

import java.util.Scanner;
import java.util.ArrayList;

public class DeadAndWounded {
	private int trys;
	public ArrayList<Integer> num;
	private ArrayList<Integer> userNum;

	public DeadAndWounded() {
		this.trys = 15;
		this.num = new ArrayList<Integer>();
		int i = 0;
		// Generates 4 dieferent Integers for num
		while (i < 4) {
			int rnd = (int) (Math.random() * 10);
			boolean diferent = true;

			for (int j = 0; j <num.size(); j++) {
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
		
	}

	public void startGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("============= Hurt and Wounded Game =============");
		System.out.println("I'm thinking of four diferent numbers from cero to nine, bouth included.");
		System.out.println("If you correctlly guess the number but not it's position it will be counted as wounded");
		System.out.println("If you guess bouth the number and it's position it will be counted as dead.");
		System.out.println("You must get four dead to win. Good luck.");
		System.out.println("==========================");
		boolean playing=true;
		while(playing){
			turn(scanner);
			trys--;
			if(trys<=0){
				System.out.println("You have run out of trys. You lose.");
				playing=flase;
			}else if(){
				System.out.println("You win! You guessed "+num.get(0)+num.get(1)+num.get(2)+num.get(3)+" in "+this.trys+" trys.");
				playing=flase;
			}
		}
	}

	public static void main(String[] args) {
		DeadAndWounded dead=new DeadAndWounded();

		
	}

}
