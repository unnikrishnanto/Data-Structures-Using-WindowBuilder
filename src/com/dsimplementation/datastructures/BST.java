package com.dsimplementation.datastructures;

public class BST {
	public static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			super();
			this.data = data;
		}
	}

	public static Node insert(Node root, int value) {
		if (root == null) {
			return new Node(value);
		}
		if (value > root.data) {
			root.right = insert(root.right, value);
		} else if (value < root.data) {
			root.left = insert(root.left, value);
		}
		return root;
	}

	public static String inOrder(Node root) {
		if (root == null) {
			return "";
		}
		String left = inOrder(root.left);
		String right = inOrder(root.right);
		return (left.isBlank() ? "" : left + ", ") + root.data + (right.isBlank() ? "" : ", " + right);
//		String tree ="";
//		tree = inOrder(root.left); initial approach
//		tree += root.data + " ";
//		tree += inOrder(root.right);
//		return inOrder(root.left) + root.data + " " +inOrder(root.right); returns extra space
	}

	public static String preOrder(Node root) {
		if (root == null)
			return "";
		String left = preOrder(root.left);
		String right = preOrder(root.right);
		return root.data + (left.isBlank() ? "" : ", " + left ) +  (right.isBlank() ? "" : ", " + right);
	}

	public static String postOrder(Node root) {
		if (root == null)
			return "";
		String left = postOrder(root.left);
		String right = postOrder(root.right);
		return (left.isBlank() ? "" : left + ", ") + (right.isBlank() ? "" : right + ", ") + root.data;
	}
	
	public static boolean search(Node root, int key) {
		if(root == null) {
			return false;
		}
		if(root.data == key) {
			return true;
		}
		return key > root.data ? search(root.right, key): search(root.left, key);
	}
	
	
	public static Node delete(Node root, int key) {
		if(root == null) {
			return null;
		}
		if(key > root.data) {
			root.right = delete(root.right, key);
		} else if (key < root.data) {
			root.left = delete(root.left, key);
		} else { //key == root.data

			//case 1 node is a leaf node
			if(root.left == null && root.right == null)
				return null; 
	
			//case 2 Node have a single subtree
			if(root.left == null) // only right child
				return root.right;
			else if(root.right == null)  // only right child.
				return root.left;
			
			// case 3 node have both children
			// replace the node value with in Order Successor
			
			Node inS = findInS(root.right);
			root.data = inS.data;
			root.right = delete(root.right, inS.data);
		}
		return root;
		
	}
	private static Node findInS(Node root) { // in order successor is the 
		while(root.left != null) {            // left most child of
			root = root.left;				  // right subtree
		}
		return root;
	}

	
}
