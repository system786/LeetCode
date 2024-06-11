class BSTIterator {
    List<Integer>list=new ArrayList<>();
    int i=-1;
    public void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);

    }
    public BSTIterator(TreeNode root) {
        inOrder(root);
    }
    
    public int next() {
        i++;
        return list.get(i);
    }
    
    public boolean hasNext() {
        return i+1<list.size()?true:false;
    }
}
