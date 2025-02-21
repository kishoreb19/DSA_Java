package greedyAlgorithms;

public class ReverseWords {

    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (word.length() != 0) {
                    word.reverse();
                    if (ans.length() > 0) ans.append(" "); // Append space only if ans is not empty
                    ans.append(word);
                    word.setLength(0); // Clear word
                }
            } else {
                word.append(s.charAt(i));
            }
        }

        // Append the last word if it exists
        if (word.length() > 0) {
            if (ans.length() > 0) ans.append(" ");
            ans.append(word.reverse());
        }

        return ans.toString();
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }
    //https://www.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
}
