class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int c : candies)
        {
            maxCandies = Math.max(maxCandies, c);
        }

        List<Boolean> ans = new ArrayList<>();
        for(int candy : candies)
        {
            if(candy + extraCandies >= maxCandies)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}