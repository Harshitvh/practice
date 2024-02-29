class Solution 
{
    public int minMutation(String start, String end, String[] bank) 
    {
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(start);
        vis.add(start);
        
        int count = 0;
        while(!q.isEmpty())
        {
            int n = q.size();
            for(int i = 0; i < n; i++)
            {
                String node = q.poll();
                if(node.equals(end))
                    return count;
                
                for(char ch: "ACGT".toCharArray())
                {
                    for(int j = 0; j < node.length(); j++)
                    {
                        char arr[] = node.toCharArray();
                        arr[j] = ch;
                        String str = String.valueOf(arr);
                        if(!vis.contains(str) && Arrays.asList(bank).contains(str))
                        {
                            q.add(str);
                            vis.add(str);
                        }
                    }
                }
            }
            count ++;
        }
        return -1;
    }
}