import java.util.*;

public class Test {

    public static void occurrence(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.replace(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for(char ch : map.keySet()){
            System.out.print(ch+""+map.get(ch)+" ");
        }
        //Time Complexity - O(N)
        //Space Complexity - O(N)
    }
    public static void main(String[] args) {
        String s = "aabccbbdd";
        occurrence(s);
    }
}