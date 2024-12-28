package datastructurealgorithms.tree.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BstPrinter {
    public static <T extends Comparable<T>> void printTree(BinarySearchTreeNode<T> root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<T>> void printNodeInternal(List<BinarySearchTreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return;
        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;
        printWhitespaces(firstSpaces);
        List<BinarySearchTreeNode<T>> newNodes = new ArrayList<>();
        for (BinarySearchTreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();
        for (int i = 1; i <= edgeLines; i++) {
            for (BinarySearchTreeNode<T> node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }
                if (node.left != null) System.out.print("/");
                else printWhitespaces(1);
                printWhitespaces(i + i - 1);
                if (node.right != null) System.out.print("\\");
                else printWhitespaces(1);
                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }
        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    private static <T extends Comparable<T>> int maxLevel(BinarySearchTreeNode<T> node) {
        if (node == null) return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T extends Comparable<T>> boolean isAllElementsNull(List<BinarySearchTreeNode<T>> list) {
        for (Object object : list) {
            if (object != null) return false;
        }
        return true;
    }
}