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
    int maxAnswer=Integer.MIN_VALUE;
    public int maxPath(TreeNode root)
    {
         if(root==null)
        return 0;

        int leftMax=maxPath(root.left);
        int rightMax=maxPath(root.right);

        int total=root.val+leftMax+rightMax;
        int returnedAnswer=Math.max(root.val,root.val+Math.max(leftMax,rightMax));
        maxAnswer=Math.max(maxAnswer,Math.max(total,returnedAnswer));

        return returnedAnswer;
    }
    public int maxPathSum(TreeNode root) 
    {
        int answer=maxPath(root);
        return maxAnswer;
    }
}