/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap();
        if(node == null) return null;
        return helper(node, map);
    }

    public Node helper(Node node, Map<Node, Node> map){
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neigh: node.neighbors){
            if(map.containsKey(neigh)){
                newNode.neighbors.add(map.get(neigh));
            }
            else{
                Node newNeigh = helper(neigh, map);
                newNode.neighbors.add(newNeigh);
            }
        }

        return newNode;
    }
}