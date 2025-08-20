class TrieNode {
    TrieNode[] children;
    boolean isEndofWord;
    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndofWord = false;
    }
}
public class Trie {
    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    // insert function
    public void insert(String word) {
        TrieNode currNode = root;
        for(char ch: word.toCharArray()) {
            int index = ch - 'a';

            if(currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            }

            currNode = currNode.children[index];
        }
        currNode.isEndofWord = true;
    }

    //search function
    public boolean search(String word) {
        TrieNode currNode  = root;
        for(char ch: word.toCharArray()) {
            int index = ch - 'a';
            if(currNode.children[index] == null) {
                return false;
            }
            currNode = currNode.children[index];
        }
        return currNode != null && currNode.isEndofWord == true;
    }
    // delete word
    public void delete(String word) {
        delete(root, word, 0);
    }

    // helper function for deleting
    public TrieNode delete(TrieNode current, String word, int idx) {
        if(idx == word.length()) {
            if(current.isEndofWord) {
                current.isEndofWord = false;
            }
            if(isEmpty(current)) {
                return null;
            }
            return current;
        }

        int charIdx = word.charAt(idx) - 'a';
        TrieNode childNode = current.children[charIdx];

        if(childNode == null) {
            return current;
        }
        current.children[charIdx] = delete(childNode, word, idx + 1);
        if (isEmpty(current) && !current.isEndofWord) {
            return null;
        }

        return current;
    }
    // isEmpty
    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("hello");
        trie.insert("heaven");
        trie.insert("hell");
        trie.insert("heavy");

        System.out.println("--- After Insertion ---");
        System.out.println("Search 'hello': " + trie.search("hello"));   
        System.out.println("Search 'hell': " + trie.search("hell"));     
        System.out.println("Search 'he': " + trie.search("he"));          
        System.out.println("Search 'heaven': " + trie.search("heaven")); 
        System.out.println("Search 'world': " + trie.search("world"));   

        System.out.println("\n--- After Deleting 'hello' ---");
        trie.delete("hello");
        System.out.println("Search 'hello': " + trie.search("hello"));   
        System.out.println("Search 'hell': " + trie.search("hell"));     
        
        System.out.println("\n--- After Deleting 'hell' ---");
        trie.delete("hell");
        System.out.println("Search 'hell': " + trie.search("hell"));     
        System.out.println("Search 'heaven': " + trie.search("heaven")); 
    }
}
