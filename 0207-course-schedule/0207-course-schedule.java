class Solution {
    // O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build a graph
        var graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] prerequisite : prerequisites) {
            var from = prerequisite[0];
            var to = prerequisite[1];

            if (!graph.containsKey(from)) graph.put(from, new ArrayList<>());
            if (!graph.containsKey(to)) graph.put(to, new ArrayList<>());

            graph.get(from).add(to);
        }

        // DFS
        for (Map.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
            var node = entry.getKey();
            var visited = new HashSet<Integer>();
            if (!DFS(graph, node, visited)) {
                return false;
            }
        }
        return true;
    }

    public Boolean DFS(HashMap<Integer, ArrayList<Integer>> graph, Integer curr, Set<Integer> visited) {
        if (visited.contains(curr)) return false; // Detected a loop! return false

        if (graph.get(curr).isEmpty()) return true; // Reached the end

        visited.add(curr);

        for (var neighbor : graph.get(curr)) {
            if (!DFS(graph, neighbor, visited)) return false;
        }

        // we have completed traversing this path.
        // Remove it from the set
        // also set the neighbors to empty so that it reaches line 29 and returns true immediately
        visited.remove(curr);
        graph.put(curr, new ArrayList<>());

        return true;
    }
}