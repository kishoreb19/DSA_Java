package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsequences {

    static void subSequences(int i,String str,String ans, ArrayList<String>result){
        if(i>=str.length()){
            result.add(ans);
            return;
        }
        char c = str.charAt(i);
        //Pick
        subSequences(i+1,str,ans+c,result);
        //Not Pick
        subSequences(i+1,str,ans,result);
    }

    static ArrayList<String> subSequences_dp(String s){
        ArrayList<String> result = new ArrayList<>();
        result.add("");
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int n = result.size();
            for(int j=0;j<n;j++){
                result.add(result.get(j)+c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> result = new ArrayList<>();
        subSequences(0,str,"",result);
        for(String s : result){
            System.out.print(s+" ");
        }
        System.out.println();
        for(String s : subSequences_dp(str)){
            System.out.print(s+" ");
        }
    }

}
