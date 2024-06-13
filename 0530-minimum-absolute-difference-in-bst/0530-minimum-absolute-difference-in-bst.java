class Solution {
    Integer prev = null; // KEY: Use Integer wrapper for null;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return minDiff;
        }
        getMinimumDifference(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;

        // Traverse the right subtree
        getMinimumDifference(root.right);

        return minDiff;
    }
}