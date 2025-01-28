package lc.general;

import common.TreeNode;

import java.util.LinkedList;

public class MaximumLevelSumOfABinaryTree_1161 {

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        int currentLevel = 1;
        int result = currentLevel;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sum = 0;
            for (int i = 0; i < levelSize; i++) {
                var current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (sum > max) {
                max = sum;
                result = currentLevel;
            }
            currentLevel++;
        }
        return result;
    }
}
