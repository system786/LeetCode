class Solution {
    public int goodNodes(TreeNode root) {
        int maxValue = -10001;

        return dfs(root,maxValue);
    }

    public int dfs(TreeNode curr, int maxVal)
    {   
        //Base case
        if(curr==null)
        {
            return 0;
        }

        //Conditions
        if (curr.val>=maxVal)
        {
            int left = dfs(curr.left,curr.val);
            int right = dfs(curr.right,curr.val);
            return 1+left+right;
        }
        else
        {
            int left = dfs(curr.left,maxVal);
            int right = dfs(curr.right,maxVal);
            return left+right;
        }
    }
}