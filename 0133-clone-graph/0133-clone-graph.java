/*
// Definition for a Node.
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
        if(node==null)
        {
            return null;
        }
       Map<Node, Node> map = new HashMap<>();
       LinkedList<Node> q = new LinkedList<>();
       q.add(node);
       while(!q.isEmpty())
       {
           Node pop = q.removeFirst();
           Node newNode = new Node(pop.val);
           map.put(pop, newNode);
           for(Node nbor : pop.neighbors)
           {
              if(!map.containsKey(nbor))
              {
                 q.add(nbor);
              }
           }
       }
       Node node1 = null; 
       for(Map.Entry m : map.entrySet())
       {
          Node oldNode =(Node) m.getKey();
          Node newNode =(Node) m.getValue();

          oldNode.neighbors.forEach(n->{
              newNode.neighbors.add(map.get(n));
          });
       }
       return map.get(node);
    }
}