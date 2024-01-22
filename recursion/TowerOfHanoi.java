package recursion;

public class TowerOfHanoi {

//    Objective - We need to move all the disks from source to destination
//    Rules :
//    Only one disk can be transferred in one step
//    Smaller disks are always kept on top of larger disks
    public static void towerOfHanoi(int n, String source, String helper, String destination){
        if(n==1){
            System.out.println("Move Disk "+n+" from "+source+" to "+destination);
            return;
        }
        towerOfHanoi(n-1,source,destination,helper);
        System.out.println("Move Disk "+n+" from "+source+" to "+destination);
        towerOfHanoi(n-1,helper,source,destination);
        //Time Complexity - O(2^N)
        //Space Complexity - O(N);
    }

    public static void main(String[] args) {
        int numberOfDisks = 2;
        String source = "A", helper = "B", destination = "C";
        towerOfHanoi(numberOfDisks,source,helper,destination);
    }
}

