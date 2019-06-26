package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinterT {

	public static <T extends Comparable<?>> void printNode(NodeT<T> root) {
		int maxLevel = BTreePrinterT.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T extends Comparable<?>> void printNodeInternal(List<NodeT<T>> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BTreePrinterT.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinterT.printWhitespaces(firstSpaces);

		List<NodeT<T>> newNodes = new ArrayList<NodeT<T>>();
		for (NodeT<T> node : nodes) {
			if (node != null) {
				System.out.print(node.data);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			BTreePrinterT.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BTreePrinterT.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					BTreePrinterT.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					BTreePrinterT.printWhitespaces(1);

				BTreePrinterT.printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					BTreePrinterT.printWhitespaces(1);

				BTreePrinterT.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <T extends Comparable<?>> int maxLevel(NodeT<T> node) {
		if (node == null)
			return 0;

		return Math.max(BTreePrinterT.maxLevel(node.left), BTreePrinterT.maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}

}
