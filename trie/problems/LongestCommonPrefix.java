package trie.problems;

public class LongestCommonPrefix {
    public static String lcp(String[] arr, int n) {
        // Write your code here
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<arr[0].length();i++){
            char c = arr[0].charAt(i);
            boolean match = true;

            for(int j=1;j<arr.length;j++){
                int l = arr[j].length();
                if(i<l && c!=arr[j].charAt(i)){
                    match = false;
                    break;
                }
            }
            if(match){
                sb.append(c);
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
