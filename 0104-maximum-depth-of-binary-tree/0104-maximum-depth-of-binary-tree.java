class Solution {
    
    public int depth(TreeNode root){
        if(root.left==null && root.right == null)
            return 1;
        
        int left = 0, right = 0;
        left = root.left!=null ? depth(root.left) : 0;
        right = root.right!=null ? depth(root.right):0;
        
        return Math.max(left,right)+1;
    }
    
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return depth(root);
    }
}