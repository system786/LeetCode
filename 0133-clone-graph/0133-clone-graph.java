class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node clone = visited.get(node); // slightly optimized here, only one time hash calculation and method call
        if (clone != null) {
            return clone;
        }
        clone = new Node(node.val);
        visited.put(node, clone);
        for (Node e : node.neighbors) {
            clone.neighbors.add(cloneGraph(e));
        }
        return clone;
    }
}