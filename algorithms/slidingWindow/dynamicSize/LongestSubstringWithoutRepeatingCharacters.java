package algorithms.slidingWindow.dynamicSize;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0,j=0;
        int n = s.length();

        int max = 0;
        while(j<n){
            char c = s.charAt(j);
            while(set.contains(c)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(c);

            max = Math.max(max, j-i+1);
            j++;
        }

        return max;
        //Time  Complexity - O(N)
        //Space Complexity - O(N) OR O(1)
    }
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/
}
