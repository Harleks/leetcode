//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 628 👎 0


package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int[] preorder;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            for (int i = 0; i < inorder.length; i++) {
                hashMap.put(inorder[i], i);
            }
            return createRoot(0, 0, preorder.length - 1);
        }

        TreeNode createRoot(int root, int left, int right) {
            if (left <= right) {
                TreeNode treeNode = new TreeNode(preorder[root]);
                int inorderRoot = hashMap.get(preorder[root]);
                treeNode.left = createRoot(root + 1, left, inorderRoot - 1);
                treeNode.right = createRoot(root + (inorderRoot - left) + 1, inorderRoot + 1, right);
                return treeNode;
            }
            return null;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}