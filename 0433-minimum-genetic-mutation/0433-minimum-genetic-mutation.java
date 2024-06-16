class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        int n = bank.length;
        int mask = 0;
        int steps = 0;
        Queue<Integer> qq = new LinkedList<>();
        qq.add(-1);
        while (!qq.isEmpty()) {
            int size = qq.size();
            while (size-- > 0) {
                int front = qq.poll();
                String str = front == -1 ? start : bank[front];
                if (str.equals(end)) return steps;
                for (int i = 0; i < n; i++) {
                    if (((mask >> i) & 1) == 1) continue;
                    int cnt = 0;
                    for (int ii = 0; ii < 8; ii++) 
                        if (str.charAt(ii) != bank[i].charAt(ii)) cnt++;
                    if (cnt == 1) {
                        qq.add(i);
                        mask |= (1 << i);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}