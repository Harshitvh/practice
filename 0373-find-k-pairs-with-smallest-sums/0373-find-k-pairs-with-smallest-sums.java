class Solution {
    class Tp {
        int sum;
        Pair<Integer, Integer> pair;

        Tp(int sum, int x, int y) {
            this.sum = sum;
            this.pair = new Pair(x, y);
        }

        Tp(int sum, Pair<Integer, Integer> pair) {
            this.sum = sum;
            this.pair = pair;
        }

        public int getSum() {
            return this.sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tp> minHeap = new PriorityQueue<>(Comparator.comparing(Tp::getSum));
        minHeap.add(new Tp(nums1[0] + nums2[0], new Pair(0, 0)));
        List<List<Integer>> res = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        visited.add(new Pair(0,0));

        for (int z = 0; z < k; z++) {
            Tp tp = minHeap.poll();
            int i = tp.pair.getKey();
            int j = tp.pair.getValue();
            res.add(List.of(nums1[i], nums2[j]));
            Pair p1 = new Pair(i+1,j);
            if (i + 1 < nums1.length && j < nums2.length && !visited.contains(p1)) {
                Tp tp1 = new Tp(nums1[i + 1] + nums2[j], new Pair(i + 1, j));
                minHeap.add(tp1);
                visited.add(p1);
            }
            Pair p2 = new Pair(i, j+1);
            if (i < nums1.length && j + 1 < nums2.length && !visited.contains(p2)) {
                Tp tp2 = new Tp(nums1[i] + nums2[j + 1], new Pair(i, j + 1));
                minHeap.add(tp2);
                visited.add(p2);

            }

        }
        return res;

    }
}