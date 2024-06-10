class Solution {
    public static void inorder(TreeNode root,int target, ArrayList<Boolean> ans){
    if(root==null){
        return;
    }
    if(root.left==null && root.right==null && target-root.val==0){
        ans.add(true);
        return;
    }
    inorder(root.left,target-root.val,ans);
    inorder(root.right,target-root.val,ans);
}
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ArrayList<Boolean> res = new ArrayList<>();
        inorder(root,targetSum,res);
        if(res.size()==0) return false;
        return true;
    }
}