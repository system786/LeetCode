class Solution {
    public int[] findOrder(final int numCourses, final int[][] prerequisites) {
        final List<Integer>[] adjacents = new List[numCourses];
        final int[] frequencies = new int[numCourses];
        int count = numCourses - 1;

        for(int[] prerequisite : prerequisites) {
            if(adjacents[prerequisite[0]] == null)
                adjacents[prerequisite[0]] = new ArrayList<>();
            
            adjacents[prerequisite[0]].add(prerequisite[1]);
            frequencies[prerequisite[1]]++;
        }

        final Queue<Integer> queue = new LinkedList<>();
        final int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; ++i) {
            if(frequencies[i] == 0) {
                result[count--] = i;
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            final int i = queue.poll();

            for(int j = 0; adjacents[i] != null && j < adjacents[i].size(); ++j) {
                final int p = adjacents[i].get(j);

                frequencies[p]--;

                if(frequencies[p] == 0) {
                    result[count--] = p;
                    queue.offer(p);
                }
            }
        }

        return count == -1 ? result : new int[0];
    }
}