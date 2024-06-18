class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, target, 0, ans, ds);
        return ans;
    }

    private void solve(int index, int[] candidates, int target, int currSum, List<List<Integer>> ans, List<Integer> ds) {
        if (currSum == target) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        if (currSum > target) {
            return;
        }
        ds.add(candidates[index]);
        solve(index, candidates, target, currSum + candidates[index], ans, ds);
        ds.remove(ds.size() - 1);
        solve(index + 1, candidates, target, currSum, ans, ds);
    }
}