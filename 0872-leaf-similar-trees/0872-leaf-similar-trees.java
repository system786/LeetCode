class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafv1=new ArrayList<>();
        List<Integer> leafv2=new ArrayList<>();

        leafnode(root1,leafv1);
        leafnode(root2,leafv2);

        return leafv1.equals(leafv2);
    }
    public void leafnode(TreeNode root, List<Integer> arr){
        if(root==null){
            return;

        }
        if(root.left==null && root.right==null){
            arr.add(root.val);
        }
        leafnode(root.left,arr);
        leafnode(root.right,arr);
    }
}