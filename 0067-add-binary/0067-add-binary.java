class Solution {
    int [] sc_0_0 = new int[] { 49, 49}; 
    int [] sc_1_0 = new int[] { 48, 49}; 
    int [] sc_2_0 = new int[] { 49, 48}; 
    int [] sc_3_0 = new int[] { 48, 48}; 

    public String addBinary(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        StringBuilder builder = new StringBuilder( n > m ? n : m);
        int c = 48;
        int []sc = sc_3_0;
        while (n >= 0 && m >= 0) {
            int x = a.charAt(n);
            int y = b.charAt(m);
            sc = twoBitAdder(x, y, c);
            c = sc[1];
            builder.append((char)sc[0]);
            n--;
            m--;
        }
        while( n>= 0) {
            int x = a.charAt(n);
            int y = 48;
            sc = twoBitAdder(x, y, c);
            c = sc[1];
            n--;
            builder.append((char)sc[0]);

        }
        while(m >= 0) {
            int x = b.charAt(m);
            int y = 48;
            sc = twoBitAdder(x, y, c);
            c = sc[1];
            builder.append((char)sc[0]);
            m--;
        }
        if(c == 49)
        builder.append((char)c);

        return builder.reverse().toString();
    }

    int[] twoBitAdder(int a, int b, int c) {
        int s = a + b + c;
        int []sc = sc_3_0;
        switch(s) {
            case 144: sc = sc_3_0; break;
            case 145: sc = sc_2_0; break;
            case 146: sc = sc_1_0; break;
            case 147: sc = sc_0_0; break;
        }
        //System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        //System.out.println(Arrays.toString(sc));
        return sc;
 
    }
}