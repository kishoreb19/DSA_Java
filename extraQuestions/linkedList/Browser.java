package extraQuestions.linkedList;

public class Browser {


    class Node{
        //Doubly Linked List
        String url;
        Node next;
        Node prev;

        Node(String url){
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }

    Node currPage = null;

    public Browser(String homePage) {
        // Write you code here
        currPage = new Node(homePage);
    }

    public void visit(String string) {
        // Write you code here
        Node temp = new Node(string);

        currPage.next = temp;
        temp.prev = currPage;

        currPage = currPage.next;

    }

    public String back(int steps) {
        // Write you code here
        for(int i=1;i<=steps;i++){
            if(currPage.prev!=null){
                currPage = currPage.prev;
            }else{
                break;
            }
        }
        return currPage.url;
    }

    public String forward(int steps) {
        // Write you code here
        for(int i=1;i<=steps;i++){
            if(currPage.next!=null){
                currPage = currPage.next;
            }else{
                break;
            }
        }
        return currPage.url;
    }
    //https://www.naukri.com/code360/problems/browser_2427908?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=PROBLEM
    //https://www.youtube.com/watch?v=mG3KLugbOdc
}