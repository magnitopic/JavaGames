package TwoNumberTarget;

import java.util.ArrayList;

public class TwoNumberTarget {
	private int target;
	public ArrayList<Integer> list;
	private ArrayList<ArrayList<Integer>> result;

	public TwoNumberTarget() {
		this.list = new ArrayList<Integer>();
		this.result = new ArrayList<ArrayList<Integer>>();
	}

	private void newTarget() {
		this.target = (int) ((Math.random() * 19) + 2);
	}

	private void newList() {
		this.list.clear();
		// Decide the leangth of the ArrayList
		int length = (int) (Math.random() * (6 - 2)) + 2;
		for (int i = 0; i < length; i++) {
			this.list.add(Integer.valueOf((int) (Math.random() * 20 + (-10))));
		}
	}

	public void filters() {
		while (this.result.size() < 100) {
			newTarget();
			newList();
			int added = 0;
			for (int i = 0; i < this.list.size(); i++) {
				for (int j = i + 1; j < (this.list.size() - i); j++) {
					if (this.list.get(i) + this.list.get(j) == this.target) {
						added++;
					}
				}
			}
			if (added == 1) {
				System.out.print("[");
				for (int i = 0; i < this.list.size() - 1; i++) {
					System.out.print(list.get(i) + ", ");
				}
				System.out.println(this.list.get(this.list.size() - 1) + "] target: " + this.target);
				this.result.add(list);
			}
		}
	}

	public static void main(String[] args) {
		TwoNumberTarget a = new TwoNumberTarget();
		a.filters();
	}

}