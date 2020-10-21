package algdat;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class BinaryTree {

	static class BinaryTreeNode{
		char value;
		BinaryTreeNode leftChild;
		BinaryTreeNode rightChild;

		BinaryTreeNode(char value){
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}

		BinaryTreeNode addLeftChild(char value){
			this.leftChild = new BinaryTreeNode(value);
			return this.leftChild;
		}

		BinaryTreeNode addRightChild(char value){
			this.rightChild = new BinaryTreeNode(value);
			return this.rightChild;
		}

	}

	static void printLevelOrder(BinaryTreeNode root){
		ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();

		// Add root-node
		queue.addFirst(root);

		while (!queue.isEmpty()){
			// 1. Remove first in queue
			BinaryTreeNode current = queue.removeFirst();

			// 2. Add current's children to queue
			if (current.leftChild != null){
				queue.addLast(current.leftChild);
			}
			if (current.rightChild != null){
				queue.addLast(current.rightChild);
			}
			// 3. Print
			System.out.println(current.value + " ");
		}
	}

	static void printPreOrder(BinaryTreeNode node){
		if (node == null){
			return;
		}

		System.out.print(node.value + " ");
		printPreOrder(node.leftChild);
		printPreOrder(node.rightChild);
	}

	static void printInOrder(BinaryTreeNode node){
		if (node == null){
			return;
		}

		System.out.print(node.value + " ");
		printInOrder(node.leftChild);
		printInOrder(node.rightChild);
	}

	static void printPostOrder(BinaryTreeNode node){
		if (node == null){
			return;
		}
		printPostOrder(node.leftChild);
		printPostOrder(node.rightChild);
		System.out.print(node.value + " ");
	}

	static void printPreOrderNonRecursive(BinaryTreeNode root){
		ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<BinaryTreeNode>();

		stack.addLast(root);

		while (!stack.isEmpty()){
			BinaryTreeNode current = stack.removeLast();

			if (current.rightChild != null) {
				stack.addLast(current.rightChild);
			}
			if (current.leftChild != null) {
				stack.addLast(current.leftChild);
			}

			System.out.print(current.value + " ");
		}
	}


	public static void main(String[] args){
		// Create root-node (level 0)
		BinaryTreeNode root = new BinaryTreeNode('A');

		// Add rest of the nodes (level 1)
		BinaryTreeNode b = root.addLeftChild('B');
		BinaryTreeNode c = root.addRightChild('C');

		// Add nodes (level 2)
		BinaryTreeNode d = b.addLeftChild('D');
		BinaryTreeNode e = b.addRightChild('E');

		// (level 3)
		BinaryTreeNode f = c.addLeftChild('F');
		BinaryTreeNode g = c.addRightChild('G');

		// Call function
		//printLevelOrder(root);

		// Print preOrde
		System.out.println("Pre Order: ");
		printPreOrder(root);

		System.out.println();
		// Print inOrder
		System.out.println("In Order: ");
		printInOrder(root);

		System.out.println();
		// Print postOrder
		System.out.println("Post Order: ");
		printPostOrder(root);

		System.out.println();
		// Printing pre order non recursively
		System.out.println("Pre Order non-recursive: ");
		printPreOrderNonRecursive(root);

	}


}
