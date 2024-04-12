class Node {
	int value;
	Node left, right;

	public Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}

class BinarySearchTree {

	Node root;

	/*
    recursive insert method
     */
    /*
    inserts a node into the tree
     */
	public void insert(int value) {
		//tree is empty
		if (root == null) {
			root = new Node(value);
			return;
		} else {
			Node current = root;
			Node parent = null;

			while (true) {
				parent = current;

				if (value < current.value) {
					current = current.left;
					if (current == null) {
						parent.left = new Node(value);
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = new Node(value);
						return;
					}
				}

			}//closing while

		}//closing main if-else
	}

	/**
	 * Performs a pre-order traversal of the binary search tree.
	 *
	 * @param root the root node of the tree
	 */
	public void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}


	/**
	 * Performs an in-order traversal of the binary search tree.
	 *
	 * @param root the root node of the tree
	 */
	public void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.value + " ");
			inOrderTraversal(root.right);
		}
	}



	/**
	 * Performs a post-order traversal of the binary search tree.
	 *
	 * @param root the root node of the tree
	 */
	public void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.value + " ");
		}
	}


	/**
	 * Finds a node with a given key in the binary search tree.
	 *
	 * @param root the root node of the tree
	 * @param key  the value to find in the tree
	 * @return the node with the given key or null if not found
	 */
	public Node find(Node root, int key) {
		while (root != null && root.value != key) {
			root = key < root.value ? root.left : root.right;
		}
		return root;
	}

	

	/**
	 * Retrieves the minimum value node in the binary search tree.
	 *
	 * @param root the root node of the tree
	 * @return the node with the minimum value
	 */
	public Node getMin(Node root) {
		if (root == null) {
			return null;
		}
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	/**
	 * Retrieves the maximum value node in the binary search tree.
	 *
	 * @param root the root node of the tree
	 * @return the node with the maximum value
	 */
	public Node getMax(Node root) {
		if (root == null) {
			return null;
		}
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	/*
    this method will not compile until getMax
    is implemented
    */
	public Node delete(Node root, int key) {

		if (root == null) {
			return root;
		} else if (key < root.value) {
			root.left = delete(root.left, key);
		} else if (key > root.value) {
			root.right = delete(root.right, key);
		} else {
			//node has been found
			if (root.left == null && root.right == null) {
				//case #1: leaf node
				root = null;
			} else if (root.right == null) {
				//case #2 : only left child
				root = root.left;
			} else if (root.left == null) {
				//case #2 : only right child
				root = root.right;
			} else {
				//case #3 : 2 children
				root.value = getMax(root.left).value;
				root.left = delete(root.left, root.value);
			}
		}
		return root;
	}
}

public class TreeDemo {
	public static void main(String[] args) {
		BinarySearchTree t1 = new BinarySearchTree();
		t1.insert(24);
		t1.insert(80);
		t1.insert(18);
		t1.insert(9);
		t1.insert(90);
		t1.insert(22);

		System.out.print("in-order :   ");
		t1.inOrderTraversal(t1.root);
		System.out.println();


	}
}
