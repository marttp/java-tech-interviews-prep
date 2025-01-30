package lc.pattern.treedfs;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII_437 {

    public class Solution1 {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            int pathCount = dfs(root, targetSum, 0);
            // Restart from left + right
            pathCount += pathSum(root.left, targetSum);
            pathCount += pathSum(root.right, targetSum);
            return pathCount;
        }

        private int dfs(TreeNode node, int targetSum, long currentSum) {
            if (node == null) {
                return 0;
            }
            long value = currentSum + node.val;
            int count = value == targetSum ? 1 : 0;
            count += dfs(node.left, targetSum, value);
            count += dfs(node.right, targetSum, value);
            return count;
        }
    }

    class Solution2PrefixSum {
        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> prefixSumMap = new HashMap<>();
            prefixSumMap.put(0L, 1);
            return dfs(root, 0L, targetSum, prefixSumMap);
        }

        private int dfs(
                TreeNode node,
                long currentSum,
                long targetSum,
                Map<Long, Integer> prefixSumMap
        ) {
            if (node == null) {
                return 0;
            }
            currentSum += node.val;
            int numPaths = prefixSumMap.getOrDefault(currentSum - targetSum, 0);
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
            numPaths += dfs(node.left, currentSum, targetSum, prefixSumMap);
            numPaths += dfs(node.right, currentSum, targetSum, prefixSumMap);
            prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);
            return numPaths;
        }
    }
}
