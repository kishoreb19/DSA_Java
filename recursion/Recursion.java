package recursion;

import java.util.ArrayList;
//07 July 2023 - 8:34:17 PM
public class Recursion {
    public static int fibo(int n){
        if(n==1 || n==0){
            //System.out.println(n);
            return n ;
        }
        int prev1 = fibo(n-1);
        int prev2 = fibo(n-2);
        return prev1+prev2;

    }
    public static int sumOfDigits(int n){
        if(0<=n && n<=9){
            return n;
        }
        return sumOfDigits(n/10)+n%10;
    }
    public static int pow(int p, int q){
        if(q==0){
            return 1;
        }
        return pow(p,q-1) * p;
    }
    public static void Multiples(int n, int k){
        if(k==1){
            System.out.print(n+" ");
            return;
        }
        Multiples(n,k-1);
        System.out.print(n*k+" ");
    }
    public static int alt(int n){
        if(n==0){
            return 0;
        }
        if(n%2==0){
            return alt(n-1)-n;
        }
        else {
            return alt(n-1)+n;
        }

    }
    public static int gcd(int x,int y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }
    public static void printArray(int arr[], int i){
        if(i==arr.length){
            return;
        }
        System.out.println(arr[i]);
        printArray(arr,i+1);
    }
    public static void it(int i,int n){
        //iteration
        if(i==n) return;
        System.out.println(i);
        it(i+1,n);
    }
    public static int maxArray(int arr[],int i){
        if(i==arr.length-1){ // single element
            return arr[i];
        }
        if(arr[i]<maxArray(arr,i+1)){
            return maxArray(arr,i+1);
        }else {
            return arr[i];
        }
    }
    public static int sumArray(int arr[],int i){
        if(i== arr.length-1){
            return arr[i];
        }
        return arr[i]+sumArray(arr,i+1);
    }
    public static boolean checkArray(int arr[],int i,int a){
        if(arr.length==i) return false;
        if(a==arr[i]) return true;
        if(checkArray(arr,i+1,a)) return true;
        else return false;
    }
    public static int linearSearch(int arr[],int e,int i){
        if(i==arr.length) return -1;
        if(e==arr[i]) return i;
        if(linearSearch(arr,e,i+1) != -1) return linearSearch(arr,e,i+1);
        else return -1;
    }
    public static void linearSearchAllIndices(int arr[], int e, int i){
        if(i==arr.length) return;
        if(e==arr[i]) System.out.println(i);
        linearSearchAllIndices(arr,e,i+1);
    }
    public static ArrayList<Integer> linearSearchAL(int arr[], int e, int i){
        ArrayList<Integer>obj = new ArrayList<>();
        if(arr.length==i){
            return new ArrayList<>();
        }
        if(arr[i]==e){
            obj.add(i);
        }
        obj.addAll(linearSearchAL(arr,e,i+1));
        return obj;
    }
    public static int lastIndex(int arr[],int e,int i){
        //input i arr.length - 1
        if(i==-1){
            return -1;
        }
        if(arr[i]==e){
            return i;
        }
        return lastIndex(arr,e,i-1);
    }
    public static boolean isSorted(int i, int arr[]){
        if(i==arr.length-1){
            return true;
        }
        return arr[i]<=arr[i+1] && isSorted(i+1,arr);
    }
    public static String removeChar(String s, char c, int i){
        String d ="";
        if(i==s.length()){
            return "";
        }
        if(s.charAt(i)!=c){
            d=d+s.charAt(i);
        }
        return d+ removeChar(s,c,i+1);
    }
    public static String removeChar2(String s, char c){
        String d ="";
        if(s.length()==0){
            return "";
        }
        if(s.charAt(0)!=c){
            d=d+s.charAt(0);
        }
        return d + removeChar2(s.substring(1),c);
    }
    public static boolean isPalindrome(String s,int l,int r){
        if(l>=r){
            return true;
        }
        return (s.charAt(l)==s.charAt(r) && isPalindrome(s,l+1,r-1));
    }
    public static String reverseString(String s, int i){
        if(i==s.length()){
            return "";
        }
        return reverseString(s,i+1) + s.charAt(i);
    }
    public static boolean checkPalindrome(String s){
        if(s.length()==0||s.length()==1){
            return true;
        }
        return (s.charAt(0)==s.charAt(s.length()-1) && checkPalindrome(s.substring(1,s.length()-1)));
    }
    public static ArrayList<String> getSubsequences(String s){
        ArrayList<String>obj=new ArrayList<>();
        if(s.length()==0){
            obj.add("");
            return obj;
        }
        char current = s.charAt(0);
        for(String s1 : getSubsequences(s.substring(1))){
            obj.add(current+s1);
            obj.add(s1);
        }
        return obj;
    }
    public static void printSubsequences(String s,String currAns){
        //let s="abc" & currAns =""
        if(s.length()==0){
            System.out.println(currAns);
            return;
        }
        char currChar = s.charAt(0);
        String remaining = s.substring(1);
        //include 'a'
        printSubsequences(remaining,currAns+currChar);
        //exclude 'a'
        printSubsequences(remaining,currAns);
    }
    public static void getSubsequencesSum(int arr[], int currSum, int i){
        if(i==arr.length){
            System.out.print(currSum+" ");
            return ;
        }
        getSubsequencesSum(arr,currSum+arr[i],i+1);
        getSubsequencesSum(arr,currSum,i+1);
    }
    public static int frog(int arr[],int h[],int i){
        if(i==arr.length-1 || i==arr.length-2){
            return 0;
        }
        int x = Math.abs(h[i+1]-h[i]) + frog(arr,h,i+1);
        int y = Math.abs(h[i+2]-h[i]) + frog(arr,h,i+2);
        return Math.min(x,y);
    }
    public static void phoneProblem(String dig,String kp[],String res){
        if(dig.isEmpty()){
            System.out.print(res+" ");
            return;
        }
        int currNum = Integer.parseInt(""+dig.charAt(0));
        String currChoice = kp[currNum];
        for(int i=0;i<currChoice.length();i++){
            phoneProblem(dig.substring(1),kp,res+currChoice.charAt(i));
        }
    }


    public static void main(String[] args) {
        int arr[]={1,2,3};
        String s="abc";
        int arr1[] = {0,1,2,3,4};
        int h[] = {10,30,20,40,50};
        String kp[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        phoneProblem("23",kp,"");
        //3-8-23
    }
}
