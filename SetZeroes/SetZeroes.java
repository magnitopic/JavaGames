package SetZeroes;

import java.util.ArrayList;

public class SetZeroes {
	private ArrayList<ArrayList<Integer>> matrix;
	private ArrayList<ArrayList<Integer>> zeroes;
	private int height = 5;
	private int width = 5;

	public SetZeroes() {
		this.matrix = new ArrayList<ArrayList<Integer>>();
		this.zeroes = new ArrayList<ArrayList<Integer>>();
	}

	public SetZeroes(int height, int width) {
		this.height = height;
		this.width = width;
		this.matrix = new ArrayList<ArrayList<Integer>>();
		this.zeroes = new ArrayList<ArrayList<Integer>>();
	}

	private void makematrix() {
		for (int i = 0; i < this.height; i++) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			for (int j = 0; j < this.width; j++) {
				if (Math.floor(Math.random() * 10) == 0) { // 10% probability of getting 0
					a.add(Integer.valueOf(0));
				} else {
					a.add(Integer.valueOf(1));
				}
			}
			this.matrix.add(a);
		}
	}

	private void getmatrix() {
		for (int j = 0; j < this.matrix.size(); j++) {
			System.out.println(this.matrix.get(j));
		}
		System.out.println("___________________");
	}

	private void getZeroes() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (this.matrix.get(i).get(j) == 0) {
					ArrayList<Integer> a = new ArrayList<Integer>();
					a.add(i);
					a.add(j);
					this.zeroes.add(a);
				}
			}
		}
	}

	private void newMatrix() {
		for (int i = 0; i <= (this.height - 1); i++) {
			for (int j = 0; j <= (this.width - 1); j++) {
				for (int k = 0; k < this.zeroes.size(); k++) {
					if (i == (this.zeroes.get(k).get(0)) || j == (this.zeroes.get(k).get(1))) {
						this.matrix.get(i).set(j, Integer.valueOf(0));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		SetZeroes a = new SetZeroes(); // It could start like this for default parameters or specify matrix height and
										// width
		a.makematrix();
		a.getmatrix();
		a.getZeroes();
		a.newMatrix();
		a.getmatrix();
	}
}