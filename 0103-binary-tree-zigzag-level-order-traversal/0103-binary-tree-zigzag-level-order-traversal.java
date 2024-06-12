class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        zigzag(root, list);
        return list;
    }
    public void zigzag(TreeNode root, List<List<Integer>> list){
        if(root==null) return;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        s1.push(root);

        while(s1.isEmpty()==false || s2.isEmpty()==false){


            List<Integer> ans1 = new ArrayList<Integer>();
            while(s1.isEmpty()==false){
                TreeNode curr = s1.pop();
                if(curr.left!=null) s2.push(curr.left);
                if(curr.right!=null)s2.push(curr.right);
                ans1.add(curr.val);
            }
            System.out.println("ans1 : " + ans1);
            list.add(ans1);

            if(!s1.isEmpty()==false && !s2.isEmpty()==false){
                break;
            }

            List<Integer> ans2 = new ArrayList<Integer>();
            while(s2.isEmpty()==false){
                TreeNode curr = s2.pop();
                if(curr.right!=null) s1.push(curr.right);
                if(curr.left!=null)  s1.push(curr.left);
                ans2.add(curr.val);
            }
            System.out.println("ans2 : " + ans2);
            // if(s1.isEmpty()==false || s2.isEmpty()==false)
            list.add(ans2);
        }
    }
}