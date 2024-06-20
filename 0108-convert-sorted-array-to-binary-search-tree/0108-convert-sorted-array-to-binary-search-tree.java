class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        if (n ==0) return null;
        if (n ==1) {
            TreeNode head = new TreeNode(nums[0]);
            return head;
        }

        TreeNode head = buildBST(nums,0,n-1);
        return head;
    }
    private TreeNode buildBST (int [] nums, int low, int high){
        if(low>high) return null;

        int mid =low+(high-low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left =buildBST(nums,low,mid-1);
        node.right =buildBST(nums,mid+1,high);
        return node;
    }
}