class Solution {
    public TreeNode createBinaryTree(int[][] arr) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            
            int p = arr[i][0];
            int c = arr[i][1];
            TreeNode parent = map.containsKey(p)?map.get(p):new TreeNode(p);
            TreeNode child = map.containsKey(c)?map.get(c):new TreeNode(c);
            if(arr[i][2]==1) parent.left = child;
            else parent.right = child;
            map.put(p,parent);
            map.put(c,child);
            set.add(c);
        }

        for(int i:map.keySet()){

            if(!set.contains(i)) return map.get(i);
        }

        return null;
        
    }
}
