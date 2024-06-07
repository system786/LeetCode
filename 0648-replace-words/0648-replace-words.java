class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet(dictionary);
        String[] tokens = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for(int i=0;i<tokens.length;i++) {
            String token = tokens[i];
            boolean found = false;
            for(int j=0;j<token.length();j++) {
                if(dict.contains(token.substring(0, j+1))) {
                    res.append(token.substring(0, j+1));
                    found = true;
                    break;
                }
            }
            if(!found) {
                res.append(token);
            }
            if(i != tokens.length-1) {
                res.append(" ");
            }
        }

        return res.toString();
    }
}