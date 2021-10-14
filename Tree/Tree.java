package Tree;

import java.util.Scanner;

/*
Create a structure witch were going to call "tree"
To do so we'll crerate 2 classes
Tree, witch contains an atrubute named "root" and is "Node" type
Node, witch has 3 atributes:
	-value, numeric type
	-leftSon, Node type
	-rightSon, Node type
Tree also has 3 methods:
	Insert -> Inserts a number, but it must complay with the rule that every node has
	to it's right nodes with higer values and to it's left nodes with lover values
	Search -> Tells you if the Tree contains a number or not
	Show -> Must some how show the tree, printing it in the terminal for example

Example:
        7
    4       9
  3  5    8   12
*/

public class Tree {
	public Node root;

	public Tree() {
		// Default value
		this.root = new Node(5);
	}

	public Tree(int value) {
		this.root = new Node(value);
	}

	public void setRootValue(int value) {
		this.root.value = value;
	}

	public void insert(int newNumber) {
		Node nodeImOn = root;

		// while newNumber is bigger or smaller than the current value and there are
		// still branches to go down
		while ((newNumber > nodeImOn.value && nodeImOn.rightSon != null)
				|| (newNumber < nodeImOn.value && nodeImOn.leftSon != null)) {
			// Check if we have to go Left or Right and change the nodeImOn to that branch
			if (newNumber > nodeImOn.value) {
				nodeImOn = nodeImOn.rightSon;
			} else if (newNumber < nodeImOn.value) {
				nodeImOn = nodeImOn.leftSon;
			}
		}
		// Once we find a node with no sons in the direction we need to go we save the
		// value to a new branch
		if (newNumber > nodeImOn.value) {
			nodeImOn.rightSon = new Node(newNumber);
			System.out.println("Saved successfully");
		} else if (newNumber < nodeImOn.value) {
			nodeImOn.leftSon = new Node(newNumber);
			System.out.println("Saved successfully");
		} else {
			System.out.println("Value already exists in Tree");
		}
	}

	public void search(int search) {
		// Search uses the same algorithm to find the value
		Node nodeImOn = root;
		while ((search > nodeImOn.value && nodeImOn.rightSon != null)
				|| (search < nodeImOn.value && nodeImOn.leftSon != null)) {
			if (search > nodeImOn.value) {
				nodeImOn = nodeImOn.rightSon;
			} else if (search < nodeImOn.value) {
				nodeImOn = nodeImOn.leftSon;
			}
		}
		// Once it finds the node "search" should be in it checks and return the result
		if (search == nodeImOn.value) {
			System.out.println("Successful! "+search + " is in the Tree structure");
		} else {
			System.out.println("Failed... "+search + " is not in the Tree structure");
		}
	}

	public void travel(Node ThisNode) {
		// It prints the Node value and calls the same function to do the same on it's
		// sons
		System.out.println(ThisNode.value);
		if (ThisNode.leftSon != null) {
			travel(ThisNode.leftSon);
		}
		if (ThisNode.rightSon != null) {
			travel(ThisNode.rightSon);
		}
	}

	public void show() {
		// We use the travel function to look through the root Node
		System.out.println("-------------------");
		travel(root);
	}

	public void random(int turns) {
		for (int i = 0; i < turns; i++) {
			insert((int) (Math.random() * 100));
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Tree tree = new Tree();

		while (true) {
			System.out.println("Give me a value for the initial Node.");
			boolean isAnInt = scanner.hasNextInt();
			if (isAnInt) {
				int value = scanner.nextInt();
				scanner.nextLine();
				tree.setRootValue(value);
				break;
			} else {
				System.out.println("Invalid value");
			}
		}

		System.out.println("-------------------");
		System.out.println("Tree Menu");
		System.out.println("");
		System.out.println("A. Insert a new number");
		System.out.println("S. Finnd a number");
		System.out.println("D. Show the numbers");
		System.out.println("F. Insert random numbers");
		System.out.println("X. Exit");
		System.out.println("-------------------");

		while (true) {
			String response = scanner.nextLine().toLowerCase();
			if (response.equals("a")) {
				System.out.println("Give me a value to insert.");
				boolean isAnInt = scanner.hasNextInt();
				if (isAnInt) {
					int value = scanner.nextInt();
					scanner.nextLine();
					tree.insert(value);
				}
			} else if (response.equals("s")) {
				System.out.println("What should I look for?");
				boolean isAnInt = scanner.hasNextInt();
				if (isAnInt) {
					int value = scanner.nextInt();
					scanner.nextLine();
					tree.search(value);
				}
			} else if (response.equals("d")) {
				tree.show();
			} else if (response.equals("f")) {
				System.out.println("How many numbers do you want to add?");
				boolean isAnInt = scanner.hasNextInt();
				if (isAnInt) {
					int value = scanner.nextInt();
					scanner.nextLine();
					tree.random(value);
				}
			} else if (response.equals("x")) {
				break;
			} else {
				System.out.println("Invalid input. Try again.");
			}
			// Options is printed down here so that it doesn't show after the menu
			System.out.println("-------------------");
			System.out.println("Options: A S D F X");
		}
		scanner.close();
	}
}
