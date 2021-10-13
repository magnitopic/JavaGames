package Tree;

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
		this.root = new Node(5);
	}

	public Tree(int value) {
		this.root = new Node(value);
	}

	public void insert(int newNumber) {
		Node nodeImOn = root;
		while ((newNumber > nodeImOn.value && nodeImOn.rightSon != null)
				|| (newNumber < nodeImOn.value && nodeImOn.leftSon != null)) {
			if (newNumber > nodeImOn.value) {
				nodeImOn = nodeImOn.rightSon;
			} else if (newNumber < nodeImOn.value) {
				nodeImOn = nodeImOn.leftSon;
			}
		}
		if (newNumber > nodeImOn.value) {
			nodeImOn.rightSon = new Node(newNumber);
			System.out.println("Saved in rightSon");
		} else if (newNumber < nodeImOn.value) {
			nodeImOn.leftSon = new Node(newNumber);
			System.out.println("Saved in leftSon");
		}else{
			System.out.println("Value already exists in Tree");
		}
	}

	public void search(int search) {
		Node nodeImOn = root;
		while ((search > nodeImOn.value && nodeImOn.rightSon != null)
				|| (search < nodeImOn.value && nodeImOn.leftSon != null)) {
			if (search > nodeImOn.value) {
				nodeImOn = nodeImOn.rightSon;
			} else if (search < nodeImOn.value) {
				nodeImOn = nodeImOn.leftSon;
			}
		}
		if (search == nodeImOn.value) {
			System.out.println(search+" is in the Tree structure");
		} else{
			System.out.println(search+" is not in the Tree structure");
		}
	}

	public void show() {
		System.out.println("Root: "+root.value);
		System.out.println(root.rightSon.value);
		System.out.println(root.rightSon.rightSon.value);
		System.out.println(root.rightSon.leftSon.value);
	}

	public static void main(String[] args) {
		Tree a = new Tree(6);
		a.insert(9);
		a.insert(9);
		a.insert(10);
		a.insert(8);
		a.search(12);
		a.show();
	}
}
