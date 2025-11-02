package graph.problems;
import java.util.*;

public class WordLadder_II {

    //Competitive Programming Approach finding answer from back
    //Solution Accepted on LeetCode
    void dfs(String word, String beginWord, HashMap<String, Integer>map, List<String>list, List<List<String>> ans){

        if(word.equals(beginWord)){
            List<String> temp = new ArrayList<>(list);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        int wordLength = word.length();
        char[] wordArray = word.toCharArray();
        for(int i=0; i<wordLength; i++){
            char originalChar = wordArray[i];
            for(char ch='a'; ch<='z'; ch++){
                wordArray[i] = ch;
                String newWord = new String(wordArray);
                if(map.containsKey(newWord) && map.get(newWord) == map.get(word) - 1){
                    list.add(newWord);
                    dfs(newWord,beginWord,map,list,ans);
                    list.remove(list.size()-1);//Backtrack
                }
            }
            wordArray[i] = originalChar;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();

        HashMap<String,Integer> map = new HashMap<>();
        Queue<String>q = new LinkedList<>();

        Set<String>set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }

        if(!set.contains(endWord)){
            return ans;
        }

        q.add(beginWord);
        map.put(beginWord,1);
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.poll();
            if(word.equals(endWord)){
                break;
            }

            int level = map.get(word);

            int wordLength = word.length();
            char[] wordArray = word.toCharArray();

            for(int i=0; i<wordLength; i++){
                char originalChar = wordArray[i];
                for(char ch = 'a'; ch<='z'; ch++){
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(set.contains(newWord)){
                        q.add(newWord);
                        set.remove(newWord);
                        map.put(newWord,level+1);
                    }
                }
                wordArray[i] = originalChar;
            }
        }



        if(map.containsKey(endWord)){
            List<String> list = new ArrayList<>();
            list.add(endWord);

            dfs(endWord,beginWord,map,list,ans);

            return ans;
        }

        return ans;//Empty List
        //N = Number of words
        //L = Length of each word
        //P = Total paths found (can vary case to case)
        //Time  Complexity = O(N * L + P * L)
        //Space Complexity = O(N + P * L)
    }

    //Not Accepted on LeetCode but good for interview approach

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        Queue<List<String>> q = new LinkedList<>();
//        q.add(Arrays.asList(beginWord));
//        Set<String> set = new HashSet<>();
//
//        for(String s : wordList){
//            set.add(s);
//        }
//
//        if(!set.contains(endWord)) return ans;
//
//        set.remove(beginWord);
//
//        while(!q.isEmpty()){
//            int size = q.size();
//
//            Set<String> used = new HashSet<>();
//            for(int level=1; level<=size; level++){
//                List<String> list = q.poll();
//                String lastWord = list.get(list.size()-1);
//
//                if(lastWord.equals(endWord)){
//                    ans.add(list);
//                }
//
//                char[] wordArray = lastWord.toCharArray();
//                for(int i=0; i<wordArray.length; i++){
//                    char  originalChar = wordArray[i];
//                    for(char ch='a'; ch<='z'; ch++){
//                        wordArray[i] = ch;
//                        String newWord = new String(wordArray);
//                        if(set.contains(newWord)){
//                            List<String> temp = new ArrayList<>(list);
//                            temp.add(newWord);
//                            q.add(temp);
//                            used.add(newWord);
//                        }
//                    }
//                    wordArray[i] = originalChar;
//                }
//            }
//            for(String s : used){
//                set.remove(s);
//            }
//        }
//
//        return ans;
//        //n = size of wordList
//        //L = length of each word
//        //Time  Complexity = O(n * L * 26) → O(n * L)
//        //Space Complexity = O(n * L)
//    }

    //There's no proper TC SC of this problem as there can be many paths
}
