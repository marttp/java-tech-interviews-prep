package lc.blind75.medium;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import common.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Mapping element kv(numValue, index)
    Map<Integer, Integer> map = IntStream.range(0, inorder.length)
        .boxed()
        .collect(Collectors.toMap((e) -> inorder[e], (e) -> e));
    return helper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
  }

  private TreeNode helper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder,
      int inorderStart, int inorderEnd, Map<Integer, Integer> inorderMapToIndex) {
    if (preorderStart >= preorderEnd || inorderStart >= inorderEnd) {
      return null;
    }
    // Use Inorder as a traversal topology look like
    int value = preorder[preorderStart];
    int rootIndex = inorderMapToIndex.get(value);
    int leftSubTreeSize = rootIndex - inorderStart;
    return new TreeNode(value,
        // left
        helper(preorder, preorderStart + 1, preorderStart + 1 + leftSubTreeSize, inorder,
            inorderStart, rootIndex, inorderMapToIndex),
        // right
        helper(preorder, preorderStart + 1 + leftSubTreeSize, preorderEnd, inorder, rootIndex + 1,
            inorderEnd, inorderMapToIndex));
  }
}
