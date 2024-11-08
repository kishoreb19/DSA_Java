package hashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class Implementation {

    static private class HashMap<K,V>{

        private class Node{
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        int n; //Number of Nodes
        int N; //Number of Buckets;
        double loadFactor; //Avg nodes per bucket
        LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")// (OPTIONAL) Since java doesn't support generic arrays, it is used to hide warnings.
        public HashMap(){
            this.n = 0;
            this.N = 4;
            this.loadFactor = 0.75;

            //Initialising Array
            buckets = new LinkedList[N];
            //Creating empty Linked List Nodes
            for(int i=0; i<N; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        int hashFunction(K key){
            int hash = key.hashCode(); // Generates an integer hash that can be positive or negative (ex: 4574 or -3456346)
            return Math.abs(hash)%N; // %N helps to bring hash within 0-(N-1) index
        }

        int findInLL(int bucketIdx, K key){
            LinkedList<Node> bucket = buckets[bucketIdx]; //Contains LinkedList Nodes

            for(int i=0;i<bucket.size();i++){
                if(bucket.get(i).key.equals(key)){
                    return i;
                }
            }
            return -1;
        }

        void reHash(){
            LinkedList<Node>[] oldBucket = buckets; //Stores old bucket reference
            this.N *= 2; //New size of bucket (usually double of old size)
            buckets = new LinkedList[N]; //New buckets array of size 2N

            //Initialising Array
            for(int i=0; i<N; i++){
                buckets[i] = new LinkedList<>();
            }

            //Take out data from old bucket and put into new bucket
            for(int i=0; i<oldBucket.length; i++){
                LinkedList<Node> bucket = oldBucket[i]; //Contains LinkedList Nodes
                for(int j=0; j<bucket.size(); j++){
                    Node curr = bucket.get(j);
                    put(curr.key, curr.value);
                }
            }
        }

        void put(K key, V value){
            int bucketIdx = hashFunction(key);
            int dataIdx = findInLL(bucketIdx, key);

            if(dataIdx==-1){
                buckets[bucketIdx].add(new Node(key,value));
                n++;
            }else{
                Node data = buckets[bucketIdx].get(dataIdx);
                data.value = value;
            }

            //Load Factor
            //Avg nodes per bucket
            double lambda = (double) n/N; // In one bucket, what is the average number of nodes?

            if(lambda > loadFactor){
                //Rehashing
                reHash();
            }

            //Avg Time Complexity - O(lambda) i.e O(1)
            //Worst Case (generally does not take place) (if all keys hash to the same bucket and rehashing occurs) - O(n)
        }

        V get(K key){
            int bucketIdx = hashFunction(key);
            int dataIdx = findInLL(bucketIdx, key);

            if(dataIdx==-1){
                return null;
            }else{
                Node data = buckets[bucketIdx].get(dataIdx);
                return data.value;
            }
        }

        V remove(K key){
            int bucketIdx = hashFunction(key);
            int dataIdx = findInLL(bucketIdx, key);

            if(dataIdx==-1){
                return null;
            }else{
                V value = buckets[bucketIdx].get(dataIdx).value;
                buckets[bucketIdx].remove(dataIdx);
                n--;
                return value;
            }
        }

        V getOrDefault(K key, V defaultValue){
            int bucketIdx = hashFunction(key);
            int dataIdx = findInLL(bucketIdx, key);

            if(dataIdx==-1){
                return defaultValue;
            }else{
                return buckets[bucketIdx].get(dataIdx).value;
            }
        }

        V putIfAbsent(K key, V defaultValue){
            int bucketIdx = hashFunction(key);
            int dataIdx = findInLL(bucketIdx, key);

            if(dataIdx==-1){
                put(key,defaultValue);
                return null;
            }else{
                return buckets[bucketIdx].get(dataIdx).value;
            }
        }

        ArrayList<K> keySet(){
            ArrayList<K> list = new ArrayList<>();

            for(int i=0; i<N; i++){
                LinkedList<Node> bucket = buckets[i];
                for(int j=0; j<bucket.size(); j++){
                    list.add(bucket.get(j).key);
                }
            }
            return list;
        }

        ArrayList<V> values(){
            ArrayList<V> list = new ArrayList<>();

            for(int i=0; i<N; i++){
                LinkedList<Node> bucket = buckets[i];
                for(int j=0; j<bucket.size(); j++){
                    list.add(bucket.get(j).value);
                }
            }
            return list;
        }

        boolean containsKey(K key){
            int bucketIdx = hashFunction(key);
            int dataIdx = findInLL(bucketIdx, key);

            return dataIdx != -1;
        }

        boolean isEmpty(){
            return n==0;
        }

        //Every Method takes O(1) Time Complexity
        //Time Complexity:

        //-> put: Average case O(1), since you’re using hash-based indexing. In the worst case (if all keys hash to the same bucket and rehashing occurs), it’s O(n).
        //-> get and remove: Average case O(1) due to hash-based lookup. Worst case O(n) if there are many collisions in one bucket.
        //-> reHash: When rehashing, all elements are reinserted, so its time complexity is O(n) for rehashing the entire HashMap.
        //-> keySet and values: These traverse all buckets and nodes, so they take O(n) time.

        //Space Complexity:

        //-> Overall Space: O(N + n), where N is the number of buckets and n is the number of elements.
    }


    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        System.out.println("isEmpty: "+map.isEmpty());

        map.put("Milk",100);
        map.put("Eggs",40);
        map.put("Cheese",60);
        map.put("Butter",200);

        System.out.println("isEmpty: "+map.isEmpty());

        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println("Removed Value: "+map.remove("Cheese"));

        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}