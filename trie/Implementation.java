package trie;

public class Implementation {
    //TrieNode stores the character and its children in an array
    static class TrieNode{
        char data;
        TrieNode[] children;
        boolean isTerminal;

        public TrieNode(char ch) {
            this.data = ch;
            this.children = new TrieNode[26];
            for(int i=0; i<children.length;i++){
                children[i] = null;
            }
            this.isTerminal = false;
        }
    }

    static class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode('\0');
        }

        private void insertUtil(TrieNode root, String word){
            if(word.length()==0){//Means the word has been traversed completely
                root.isTerminal = true;
                return;
            }
            //Assumption -> word is all CAPS
            int index = word.charAt(0) - 'A';
            TrieNode child;
            if(root.children[index] != null){
                //Present
                child = root.children[index];
            }else{
                //Absent
                child = new TrieNode(word.charAt(0));
                root.children[index] = child;
            }
            //Recursion
            insertUtil(child,word.substring(1));
        }

        void insertWord(String word){
            insertUtil(root, word);
            //Time  Complexity - O(L) [As we are processing each character of the word][L-> Length of word.]
            //Space Complexity - O(L)
        }

        boolean searchUtil(TrieNode root, String word){
            if(word.length()==0){//Means the word has been traversed completely
                return root.isTerminal;
            }
            int index = word.charAt(0) - 'A';
            TrieNode child;

            if(root.children[index] != null){
                child = root.children[index];
            }else{
                return false;
            }

            return searchUtil(child, word.substring(1));
        }

        boolean search(String word){
            return searchUtil(root, word);
            //Time  Complexity - O(L)
            //Space Complexity - O(L)
        }

        void removeUtil(TrieNode root, String word) {
            if (word.length() == 0) {
                if (!root.isTerminal) {
                    System.out.println("Word Not Found!");
                } else {
                    root.isTerminal = false;
                }
                return;
            }

            int index = word.charAt(0) - 'A';
            TrieNode child = root.children[index];

            if (child == null) {
                System.out.println("Word Not Present!");
                return;
            }

            // Recursive call to proceed with the next character
            removeUtil(child, word.substring(1));

            // After returning, check if the child node is now redundant
            if (!child.isTerminal && isEmpty(child)) {
                root.children[index] = null;
            }
        }

        // Helper function to check if a node has any children
        boolean isEmpty(TrieNode node) {
            for (TrieNode child : node.children) {
                if (child != null) return false;
            }
            return true;
            //Time  Complexity - O(26) -> O(1)
            //Space Complexity - O(1)
        }

        void remove(String word){
            removeUtil(root,word);
            //Time  Complexity - O(L)
            //Space Complexity - O(L)
        }

        //Returns if there is any word in the trie that starts with the given prefix
        boolean startsWithUtil(TrieNode root, String prefix){
            if(prefix.length()==0){
                return true;
            }
            int index = prefix.charAt(0) - 'A';
            TrieNode child;
            if(root.children[index]!=null){
                child = root.children[index];
            }else{
                return false;
            }
            return startsWithUtil(child, prefix.substring(1));
        }

        public boolean startsWith(String prefix) {
            return startsWithUtil(root, prefix);
            //Time  Complexity - O(P)
            //Space Complexity - O(P)
            //https://www.naukri.com/code360/problems/implement-trie_631356?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
        }
    }


    public static void main(String[] args) {
        Trie t = new Trie();
        t.insertWord("TIME");
        System.out.println(t.search("TIME"));
        t.remove("TIM");
        System.out.println(t.search("TIME"));
    }
}