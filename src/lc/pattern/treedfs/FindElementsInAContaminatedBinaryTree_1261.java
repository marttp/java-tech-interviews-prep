package lc.pattern.treedfs;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInAContaminatedBinaryTree_1261 {
    class FindElements {

        private TreeNode root;
        private Set<Integer> storedValue;

        public FindElements(TreeNode root) {
            storedValue = new HashSet<>();
            cleanTree(root, 0);
        }

        private void cleanTree(TreeNode node, int value) {
            node.val = value;
            storedValue.add(value);
            if (node.left != null) {
                cleanTree(node.left, 2 * node.val + 1);
            }
            if (node.right != null) {
                cleanTree(node.right, 2 * node.val + 2);
            }
        }

        public boolean find(int target) {
            return storedValue.contains(target);
        }
    }
}
