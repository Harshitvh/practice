class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxProfit = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Pair<Integer, Integer>> minCapital = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        for (int i = 0; i < capital.length; i++) {
            minCapital.add(new Pair(capital[i], profits[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && minCapital.peek().getKey() <= w) {
                Pair<Integer, Integer> pair = minCapital.poll();
                maxProfit.add(pair.getValue());
            }
            if (maxProfit.isEmpty()) {
                return w;
            }
            w = w + maxProfit.poll();
        }
        return w;

    }
}