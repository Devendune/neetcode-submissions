/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) 
    {
        if(root==null)
        return null;

        TreeNode leftCall=invertTree(root.left);
        TreeNode rightCall=invertTree(root.right);

        root.left=rightCall;
        root.right=leftCall;

        return root;

    }
}
