class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    TreeNode helper(int[] preorder, int[] inorder, int pS, int pE, int iS, int iE) {
        if (iS > iE || iS < 0 || iS >= inorder.length || iE < 0 || iE >= inorder.length) {
            return null;
        }
        if (pS >= preorder.length || pE >= preorder.length || pS > pE) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pS]);

        int inIndex = map.get(preorder[pS]);
        int size = inIndex - iS;

        TreeNode left = helper(preorder, inorder, pS + 1, pS + size, iS, inIndex - 1);
        TreeNode right = helper(preorder, inorder, pS + size + 1, pE, inIndex + 1, iE);

        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}