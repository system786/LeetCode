class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2]; 
        inorderTraversal(root, k, result);
        
        return result[0];
    }
    
    private void inorderTraversal(TreeNode node, int k, int[] result) {
        if (node == null || result[1] >= k) {
            return;
        }
        inorderTraversal(node.left, k, result);
    
        result[1]++;  
        if (result[1] == k) {
            result[0] = node.val;
            return;
        }
        
        inorderTraversal(node.right, k, result);
    }
}