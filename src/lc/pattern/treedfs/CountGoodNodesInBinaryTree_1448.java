package lc.pattern.treedfs;

import common.TreeNode;

public class CountGoodNodesInBinaryTree_1448 {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        int count = node.val >= maxSoFar ? 1 : 0;
        maxSoFar = Integer.max(node.val, maxSoFar);
        return count + dfs(node.left, maxSoFar) + dfs(node.right, maxSoFar);
    }
}
