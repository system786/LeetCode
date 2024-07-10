class Solution {
    public int compress(char[] chars) 
    {
        int p=0;
        
        int i=0;
        String res="";
        while(i<chars.length)
        {
            int count=0;
            char curr=chars[i];
            
            while(i<chars.length && curr==chars[i] )
            {
                i++;
                count++;
            }
            chars[p++]=curr;
            if(count>1)
            {
            for(char j:String.valueOf(count).toCharArray())
            {
                chars[p++]=j;
            }
            }
        }
        return p;   
    }
}