//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 352 👎 0


import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private class Node{
        private boolean isWords;
        private TreeMap<Character, Node>  next;

        public Node(boolean isWords) {
            this.isWords = isWords;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWords = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWords;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if(cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
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
//leetcode submit region end(Prohibit modification and deletion)