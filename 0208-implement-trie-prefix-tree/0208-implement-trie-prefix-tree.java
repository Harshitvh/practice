class Trie {
    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean eos;

        public TrieNode() {
            this.children = new HashMap<>();
            this.eos = false;
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {

            if (!current.children.containsKey(word.charAt(i))) {
                current.children.put(word.charAt(i), new TrieNode());
            }
            current = current.children.get(word.charAt(i));
        }
        current.eos = true;

    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.children.containsKey(word.charAt(i))) {
                return false;
            }
            current = current.children.get(word.charAt(i));
        }
        if (current.eos == true) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!current.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            current = current.children.get(prefix.charAt(i));
        }

        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */