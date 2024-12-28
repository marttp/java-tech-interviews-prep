package datastructurealgorithms.tree;

import common.TreeNode;
import datastructurealgorithms.tree.binary.BinarySearchTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeDemo {

    public static void main(String[] args) {
//        bst();
        binaryTree();
    }

    private static void binaryTree() {
        TreeNode root = generateTree();
        // Preorder => 3 8 23 13 1 50 6
        List<Integer> preorderResult = new ArrayList<>();
        Traversal.preorderTraversal(root, preorderResult);
        System.out.println("Preorder traversal: " + Arrays.toString(preorderResult.toArray()));
        // Inorder => 23 8 13 3 6 50 1
        List<Integer> inorderResult = new ArrayList<>();
        Traversal.inorderTraversal(root, inorderResult);
        System.out.println("Inorder traversal: " + Arrays.toString(inorderResult.toArray()));
        // Postorder => 23 13 8 6 50 1 3
        List<Integer> postorderResult = new ArrayList<>();
        Traversal.postorderTraversal(root, postorderResult);
        System.out.println("Postorder traversal: " + Arrays.toString(postorderResult.toArray()));
        // Level Order Traversal => [[3], [8,1], [23,13,50], [6]]
        System.out.println("Level order traversal: " + Traversal.levelOrderTraversal(root));
    }

    private static TreeNode generateTree() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1);
        node3.left = node8;
        node3.right = node1;

        TreeNode node23 = new TreeNode(23);
        TreeNode node13 = new TreeNode(13);
        node8.left = node23;
        node8.right = node13;

        TreeNode node50 = new TreeNode(50);
        node1.left = node50;
        TreeNode node6 = new TreeNode(6);
        node50.left = node6;

        return node3;
    }

    private static void bst() {
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9);
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
        for (Integer id : ids) {
            root.insert(id);
        }
//        BstPrinter.printTree(root);
        System.out.println("Binary search result: " + BinarySearchTreeNode.searchBST(root, 8));
        System.out.println("Binary search result: " + BinarySearchTreeNode.searchBST(root, 10));
    }
}
