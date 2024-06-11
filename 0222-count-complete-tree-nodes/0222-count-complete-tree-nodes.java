class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftcount = countNodes(root.left);
        int rightcount = countNodes(root.right);
        int totalnumber = leftcount+rightcount+1;
    return totalnumber;}
}
