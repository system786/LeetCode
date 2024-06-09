class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null)
            return null;
        HashMap <Integer,Integer> mp = new HashMap <Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
            mp.put(inorder[i],i);
        return Tree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,mp);
    }
    public TreeNode Tree(int []inorder,int instr,int inend,int postorder[],int postr,int poend,HashMap<Integer,Integer> mp)
    {
        if(instr>inend||postr>poend)
            return null;
        TreeNode root=new TreeNode(postorder[poend]);
        int rtind=mp.get(postorder[poend]);
        int numsleft=rtind-instr;
        root.left=Tree(inorder,instr,rtind-1,postorder,postr,postr+numsleft-1,mp);                                             
        root.right=Tree(inorder,rtind+1,inend,postorder,postr+numsleft,poend-1,mp);
        return root;
    }
}