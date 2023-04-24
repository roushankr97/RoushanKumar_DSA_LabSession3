package com.greatlearning.dsaprogram2;

import java.util.*;

class Pair {
	static class Node {
		int nodeData;
		Node leftNode, rightNode;

	}

	static Node NewNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}

	public Node insert(Node root, int key) {
		if (root == null)
			return NewNode(key);
		if (key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	public boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;
		if (findpairUtil(root.leftNode, sum, set))
			return true;
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found(" + (sum - root.nodeData) + "," + root.nodeData + ")");
			return true;

		} else
			set.add(root.nodeData);
		return findpairUtil(root.rightNode, sum, set);

	}

	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpairUtil(root, sum, set))
			System.out.println("Pairs do not exit" + "\n");
	}

	public static void main(String args[]) {     // driver code
		Node root = null;
		Pair findpair = new Pair();
		root = findpair.insert(root, 10);     //keys
		root = findpair.insert(root, 20);
		root = findpair.insert(root, 30);
		root = findpair.insert(root, 40);
		root = findpair.insert(root, 50);
		root = findpair.insert(root, 60);
		root = findpair.insert(root, 70);
		int sum = 130;
		findpair.findPairWithGivenSum(root, sum);

	}
}