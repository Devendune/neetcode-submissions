
class Solution 
{
    Map<TreeNode,Integer> map=new HashMap<>();
    public int rob(TreeNode root) 
    {
        if(root==null)
        return 0;

        if(map.containsKey(root))
        return map.get(root);

        int leftGrandChild=0,rightGrandChild=0;
        if(root.left!=null)
        leftGrandChild=rob(root.left.left)+rob(root.left.right);

        if(root.right!=null)
        rightGrandChild=rob(root.right.left)+rob(root.right.right);

        int selectRoot=root.val+leftGrandChild+rightGrandChild;

        int ignoreRoot=rob(root.left)+rob(root.right);

        map.put(root,Math.max(selectRoot,ignoreRoot));
        return Math.max(selectRoot,ignoreRoot);

    }
}