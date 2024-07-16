class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            arr.add(new ArrayList<Integer>());
        }
        int n = nums1.length; int m = nums2.length;
        int i = 0; int j = 0;
        int x = 0; int y = 0;
        while(i < n && j < m) {
            if(nums1[i] < nums2[j]){
                if(x < 1 || nums1[i] != arr.get(0).get(x-1)){
                    arr.get(0).add(nums1[i]);
                    x++;
                }
                i++;
            } else if (nums1[i] > nums2[j]){
                j++;
            } else {
                i++;
                // j++;
            }
        }
        while(i < n){
            // System.out.println("avy" + nums1[i]);
            if(x < 1 || nums1[i] != arr.get(0).get(x-1)){
                arr.get(0).add(nums1[i]);
                x++;
            }
            i++;
        }

        i = 0; j = 0;
        while(i < n && j < m){
            if(nums2[j] < nums1[i]){
                if(y < 1 || nums2[j] != arr.get(1).get(y-1)){
                    arr.get(1).add(nums2[j]);
                    y++;
                }
                j++;
            } else if (nums2[j] > nums1[i]){
                i++;
            } else {
                // i++;
                j++;
            }
        }

        while(j < m){
            if(y < 1 || nums2[j] != arr.get(1).get(y-1)){
                arr.get(1).add(nums2[j]);
                y++;
            }
            j++;
        }

        return arr;
    }
}