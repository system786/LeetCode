class Solution {
    private int max = -1001;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int tempMax = Math.max(root.val, root.val + l);
        tempMax = Math.max(tempMax, root.val + r);
        max = Math.max(max, root.val);
        max = Math.max(max, tempMax);
        max = Math.max(max, root.val + l + r);
        return tempMax;
    }
}