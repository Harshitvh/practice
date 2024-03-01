class Solution {
    public int ladderLength(String start, String end, List<String> wordList) {
        wordList.add(start);
        Map<String, List<String>> graph = buildGraph(wordList);
        LinkedList<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start);
        q.add(start);
        int count = 1;
        while (!q.isEmpty()) {
            int length = q.size();
            for (int z = 0; z < length; z++) {
                String pop = q.removeFirst();

                if (pop.equals(end)) {
                    return count;
                }
                for (int i = 0; i < pop.length(); i++) {
                    String res = pop.substring(0, i) + '*' + pop.substring(i + 1);
                    List<String> nbors = graph.get(res) != null ? graph.get(res) : new ArrayList<>();
                    for (String nbor : nbors) {
                        if (!visited.contains(nbor)) {
                            q.add(nbor);
                            visited.add(nbor);
                        }
                    }
                }
            }
            count = count + 1;
        }
        return 0;
    }

    private Map<String, List<String>> buildGraph(List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String res = word.substring(0, i) + '*' + word.substring(i + 1);
                map.putIfAbsent(res, new LinkedList<>());
                map.get(res).add(word);
            }
        }
        return map;

    }
}