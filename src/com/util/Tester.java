package com.util;

public class Tester {

	public static void main(String[] args) {
		BTreePrinterT.printNode(test1());
	}

	private static NodeT<Integer> test1() {
		NodeT<Integer> root = new NodeT<Integer>(2);
		NodeT<Integer> n11 = new NodeT<Integer>(7);
		NodeT<Integer> n12 = new NodeT<Integer>(5);
		NodeT<Integer> n21 = new NodeT<Integer>(2);
		NodeT<Integer> n22 = new NodeT<Integer>(6);
		NodeT<Integer> n23 = new NodeT<Integer>(3);
		NodeT<Integer> n24 = new NodeT<Integer>(6);
		NodeT<Integer> n31 = new NodeT<Integer>(5);
		NodeT<Integer> n32 = new NodeT<Integer>(8);
		NodeT<Integer> n33 = new NodeT<Integer>(4);
		NodeT<Integer> n34 = new NodeT<Integer>(5);
		NodeT<Integer> n35 = new NodeT<Integer>(8);
		NodeT<Integer> n36 = new NodeT<Integer>(4);
		NodeT<Integer> n37 = new NodeT<Integer>(5);
		NodeT<Integer> n38 = new NodeT<Integer>(8);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;
		n12.left = n23;
		n12.right = n24;

		n21.left = n31;
		n21.right = n32;
		n22.left = n33;
		n22.right = n34;
		n23.left = n35;
		n23.right = n36;
		n24.left = n37;
		n24.right = n38;

		return root;
	}
}
