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
class Solution 
{
    private boolean validBST(TreeNode root,long minValue,long maxValue)
    {
        if(root==null)
        return true;

        if(root.val<=minValue || root.val>=maxValue)
        return false;

        boolean leftCall=validBST(root.left,minValue,root.val);
        boolean rightCall=validBST(root.right,root.val,maxValue);

        return leftCall&&rightCall;
    }
    public boolean isValidBST(TreeNode root) 
    {
     return validBST(root,-3000000000L,3000000000L);   
    }
}