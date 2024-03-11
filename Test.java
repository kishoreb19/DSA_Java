import binaryTree.BTBuild_Traversal;

import java.util.*;

class A{
    static int count=0;
    A(){
        count++;
    }
    void display(){
        System.out.println("Count: "+count);
    }
}
public class Test {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        A c = new A();
        a.display();
    }
}