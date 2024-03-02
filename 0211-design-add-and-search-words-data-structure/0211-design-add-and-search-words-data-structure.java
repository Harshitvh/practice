class WordDictionary {
    private TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> map;
        boolean eos;

        public TrieNode() {
            this.map = new HashMap<>();
            this.eos = false;
        }
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.map.containsKey(word.charAt(i))) {
                current.map.put(word.charAt(i), new TrieNode());
            }
            current = current.map.get(word.charAt(i));
        }
        current.eos = true;

    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.map.containsKey(word.charAt(i))) {
                if (word.charAt(i) == '.') {
                    return check(current, word.substring(i + 1, word.length()));
                }
                return false;
            }
            current = current.map.get(word.charAt(i));
        }
        if (current.eos) {
            return true;
        }
        return false;
    }

    public boolean search(String word, TrieNode current) {
        for (int i = 0; i < word.length(); i++) {
            if (!current.map.containsKey(word.charAt(i))) {
                if (word.charAt(i) == '.') {
                    return check(current, word.substring(i + 1, word.length()));
                }
                return false;
            }
            current = current.map.get(word.charAt(i));
        }
        if (current.eos) {
            return true;
        }
        return false;
    }

    private boolean check(TrieNode current, String word) {
        for (Map.Entry<Character, TrieNode> e : current.map.entrySet()) {
            if (search(word, e.getValue())) {
                return true;
            }
        }
        return false;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */