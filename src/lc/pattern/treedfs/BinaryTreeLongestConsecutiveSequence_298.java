package lc.pattern.treedfs;

import common.TreeNode;

public class BinaryTreeLongestConsecutiveSequence_298 {

    public int longestConsecutive(TreeNode root) {
        int[] longest = {1};
        dfs(root, 1, longest);
        return longest[0];
    }

    public void dfs(TreeNode node, int current, int[] longest) {
        if (node == null) {
            return;
        }
        longest[0] = Integer.max(longest[0], current);
        if (node.left != null && node.left.val == node.val + 1) {
            dfs(node.left, current + 1, longest);
        } else {
            longest[0] = Integer.max(longest[0], longestConsecutive(node.left));
        }
        if (node.right != null && node.right.val == node.val + 1) {
            dfs(node.right, current + 1, longest);
        } else {
            longest[0] = Integer.max(longest[0], longestConsecutive(node.right));
        }
    }
}
