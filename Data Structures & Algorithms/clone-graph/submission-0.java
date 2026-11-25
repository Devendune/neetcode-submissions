class Solution {
    private Map<Node, Node> copies = new HashMap<>();   // original node -> its copy

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (copies.containsKey(node)) return copies.get(node);   // already copied

        Node copy = new Node(node.val);
        copies.put(node, copy);                                  // record BEFORE visiting neighbours

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));            // copy of the neighbour
        }
        return copy;
    }
}