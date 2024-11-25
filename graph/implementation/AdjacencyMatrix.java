package graph.implementation;

import java.util.*;

public class AdjacencyMatrix {
    static class Graph{
        ArrayList<ArrayList<Integer>> adj;

        Graph(int n){
            adj = new ArrayList<>();
            for(int i=0;i<n;i++){
                ArrayList<Integer> row = new ArrayList<>();
                for(int j=0;j<n;j++){
                    row.add(j,0);
                }
                adj.add(row);
            }
        }


        void addEdge(int src, int dest, boolean direction){

            adj.get(src).set(dest,1);

            if(!direction){
                adj.get(dest).set(src,1);
            }
        }

        void printAdjMatrix(){
            int n = adj.size();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(adj.get(i).get(j)+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,m;
        System.out.print("Enter number of nodes: ");
        n = sc.nextInt();

        Graph g = new Graph(n);

        System.out.print("Enter number of edges: ");
        m = sc.nextInt();
        System.out.println();

        for(int i=0;i<m;i++){
            g.addEdge(sc.nextInt(),sc.nextInt(),false);
        }
        System.out.println("Adjacency Matrix");
        g.printAdjMatrix();
    }
}
