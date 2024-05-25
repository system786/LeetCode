class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper(s,0,set);
    }
    private List<String> helper(String str, int s, Set<String> set){
        List<String> valid = new ArrayList<>();
        if(s == str.length()){
            valid.add("");
        }
        for(int e = s+1; e <= str.length(); e++){
            String pre = str.substring(s, e);
            if(set.contains(pre)){
                List<String> suff = helper(str, e, set);
                for(String suf : suff){
                    valid.add(pre + (suf.equals("") ? "" : " ")+ suf);
                }
            }
        }
        return valid;
    }
}