package graph.problems;
import java.util.*;

public class CheapestFlightsWithinKStops {

    class Pair{
        int node, price;
        Pair(int node, int price){
            this.node = node;
            this.price = price;
        }
    }

    class Tuple{
        int node,stops,price;
        Tuple(int node, int stops, int price){
            this.node = node;
            this.stops = stops;
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Pair>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<flights.length; i++){
            int source = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];

            adj[source].add(new Pair(dest,price));
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(src,0,0));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            int node = t.node;
            int stops = t.stops;
            int price = t.price;


            if(stops > k) continue;

            for(Pair neighbor : adj[node]){
                int neighborNode = neighbor.node;
                int neighborPrice =  neighbor.price;

                int newPrice = price + neighborPrice;
                if(newPrice < prices[neighborNode]){
                    prices[neighborNode] = newPrice;
                    q.add(new Tuple(neighborNode, stops+1, newPrice));
                }
            }
        }
        //n = number of cities
        //E = number of flights
        //k = maximum allowed stops

        //Time  Complexity - O(k * E)
        //Space Complexity - O(n + E)
        return prices[dst]==Integer.MAX_VALUE? -1 : prices[dst];
    }
    //https://leetcode.com/problems/cheapest-flights-within-k-stops/
}
