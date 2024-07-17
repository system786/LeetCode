class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> delete = new ArrayList<>();
        for(int i:to_delete) delete.add(i);
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        map.put(root,null);
        find_parent(root,map);
        delete_node(root,delete,list,map);
        return list; 
    }
    void traverse(TreeNode node, List<Integer> delete, List<TreeNode> list, HashMap<TreeNode,TreeNode> map){

        if(node==null) return;
        if(delete.contains(node.val)) delete_node(node, delete, list,  map);
        else{
            traverse(node.left,delete,list,map);
            traverse(node.right,delete,list,map);
        }
    }
    void delete_node(TreeNode node, List<Integer> delete, List<TreeNode> list, HashMap<TreeNode,TreeNode> map){
        if(node==null) return;

        if(!delete.contains(node.val)) {
            list.add(node);
            traverse(node,delete,list,map);
        }
        else{
            TreeNode parent = map.get(node);
            if(parent!=null && parent.left!=null && parent.left==node) parent.left = null;
            if(parent!=null && parent.right!=null && parent.right==node) parent.right = null;
            delete_node(node.left,delete,list,map);
            delete_node(node.right,delete,list,map);
        }


    }
    void find_parent(TreeNode node, HashMap<TreeNode,TreeNode> map){
        if(node==null) return;

        if(node.left!=null) map.put(node.left,node);
        if(node.right!=null) map.put(node.right,node);
        find_parent(node.left,map);
        find_parent(node.right,map);
    }
}