package graph.problems;
import java.util.*;

public class WordLadder_I {

    class Pair{
        String word;
        int level;
        Pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        HashSet<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }

        if(!set.contains(endWord)) return 0;

        HashSet<String>visited = new HashSet<>();
        visited.add(beginWord);

        while(!q.isEmpty()){
            Pair node = q.poll();

            String currWord = node.word;
            char[] wordChar = currWord.toCharArray();

            int currLevel = node.level;
            int wordLength = currWord.length();

            if(currWord.equals(endWord)){
                return currLevel;
            }

            for(int i=0; i<wordLength; i++){
                char originalChar = wordChar[i];
                for(char ch='a'; ch<='z'; ch++){
                    wordChar[i] = ch;
                    String newWord = new String(wordChar);
                    if(!visited.contains(newWord) && set.contains(newWord)){
                        visited.add(newWord);
                        q.add(new Pair(newWord,currLevel+1));
                    }
                    wordChar[i] = originalChar;
                }
            }
        }

        return 0;
        //n = size of wordList
        //L = length of each word
        //Time  Complexity = O(n * L * 26) → O(n * L)
        //Space Complexity = O(n * L)
    }

    //More Faster
    //Using set.remove(newWord) directly eliminates the need for a separate visited HashSet → saves extra space & reduces lookup overhead.

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Queue<Pair> q = new LinkedList<>();
//        q.add(new Pair(beginWord,1));
//
//        HashSet<String> set = new HashSet<>();
//        for(String s : wordList){
//            set.add(s);
//        }
//
//        if(!set.contains(endWord)) return 0;
//
//        set.remove(beginWord); //Mark Visited
//
//        while(!q.isEmpty()){
//            Pair node = q.poll();
//
//            String currWord = node.word;
//            char[] wordChar = currWord.toCharArray();
//
//            int currLevel = node.level;
//            int wordLength = currWord.length();
//
//            if(currWord.equals(endWord)){
//                return currLevel;
//            }
//
//            for(int i=0; i<wordLength; i++){
//                char originalChar = wordChar[i];
//                for(char ch='a'; ch<='z'; ch++){
//                    wordChar[i] = ch;
//                    String newWord = new String(wordChar);
//                    if(set.contains(newWord)){
//                        set.remove(newWord);
//                        q.add(new Pair(newWord,currLevel+1));
//                    }
//                    wordChar[i] = originalChar;
//                }
//            }
//        }
//        return 0;
//        //n = size of wordList
//        //L = length of each word
//        //Time  Complexity = O(n * L * 26) → O(n * L)
//        //Space Complexity = O(n * L)
//    }

    //https://leetcode.com/problems/word-ladder/description/
}
