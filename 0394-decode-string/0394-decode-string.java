class Solution {
    public String decodeString(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch!=']'){
                st.push(ch);
            }
            else{
                sb=new StringBuilder();
                while(!st.isEmpty() && Character.isLetter(st.peek())){
                    sb.insert(0,st.pop());
                }
                st.pop(); // remove'['
                String sub=sb.toString();
                sb=new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    sb.insert(0,st.pop());
                }
                int num=Integer.valueOf(sb.toString());
                while(num-->0){
                    for(char c:sub.toCharArray()){
                        st.push(c);
                    }
                }
            }
        }
        sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}