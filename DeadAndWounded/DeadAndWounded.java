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

	public static void main(String[] args) {
		DeadAndWounded dead=new DeadAndWounded();
		for(int i=0;i<=3;i++){
			System.out.println(dead.num.get(i));
		}

		
	}

}
