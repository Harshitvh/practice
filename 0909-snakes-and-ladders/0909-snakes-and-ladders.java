class Solution {
    class Node {
        int val;
        int moves;

        public Node(int val, int moves) {
            this.val = val;
            this.moves = moves;
        }
    }

    class Index{
    int r;
    int c;
     Index(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }

    public int snakesAndLadders(int[][] board) {
        reverse(board);
        return bfs(board, new Node(1, 0), new HashSet<>());
    }

    public void reverse(int[][] board)
    {
        for(int i=0;i<board.length/2;i++)
        {
           int[] temp = board[i];
           board[i] =  board[board.length-1-i];
           board[board.length-1-i]= temp;
        }
    }

    public int bfs(int[][] board, Node node, Set<Integer> visited) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node pop = q.removeFirst();
            for (int i = 1; i<=6; i++) {
                int nbor = pop.val + i;
                int length = board.length;
                Index idx = getIndex(length, nbor);
                int value = board[idx.r][idx.c];
                if (value != -1) {
                    nbor = value;
                }
                  if (nbor == length * length) {
                    return pop.moves + 1;
                }
                if (!visited.contains(nbor)) {
                    Node n = new Node(nbor, pop.moves + 1);
                    visited.add(nbor);
                    q.add(n);
                }

            }
        }
        return -1;

    }

    private Index getIndex(int length, int nbor)
    {
        int r = (nbor-1)/length;
        int c = (nbor-1)%length;
        if(r%2==1)
        {
            c = length-1-c;
        }
      return new Index(r,c);
    }
}