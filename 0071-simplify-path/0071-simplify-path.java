class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String arr[]= path.split("/");
        for(int i=0;i<arr.length;i++)
        {
            if(!stack.isEmpty()&& arr[i].equals("..") )
            stack.pop();
            else if(!arr[i].equals("")&&!arr[i].equals(".")&& !arr[i].equals(".."))
            {stack.push(arr[i]);}
        }
       String ans="";
        if(stack.isEmpty())return "/";
        while(!stack.isEmpty())
        {
            ans="/"+stack.pop()+ans;
        }
        return ans;
    }
}