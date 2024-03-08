class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> temp = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        int sum = 0;
        dfs(0, sum, candidates, target, temp, result);
        return result;
    }

    private void dfs(int i, int sum, int[] candidates, int target,
    LinkedList<Integer> temp, List<List<Integer>> res) {
          if(sum==target)
        {
            res.add(new LinkedList<Integer>(temp));
            return;
        }
        if(sum > target || i>=candidates.length)
        {
            return;
        }
      
        temp.add(candidates[i]);
        sum = sum + candidates[i];
        dfs(i+1, sum, candidates, target, temp, res);
        temp.removeLast();
        sum = sum - candidates[i];
        while(i+1<candidates.length && candidates[i+1]==candidates[i])
        {
            i=i+1;
        }
        dfs(i+1, sum, candidates, target, temp, res);
    }
}