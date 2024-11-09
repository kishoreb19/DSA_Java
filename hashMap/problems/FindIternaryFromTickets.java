package hashMap.problems;

import java.util.HashMap;

public class FindIternaryFromTickets {
    public static String itineraryFromTickets(HashMap<String,String>tickets){
        StringBuilder sb = new StringBuilder();
        String start = "";

        //'start' should not be present in 'To'
        for(String from : tickets.keySet()){
            if(!tickets.containsValue(from)){
                start = from;
            }
        }

        sb.append(start);
        while (tickets.containsKey(start)){
            start = tickets.get(start);
            sb.append("->");
            sb.append(start);
        }
        return sb.toString();
        //Time Complexity - O(N)
        //Space Complexity - O(N)
    }

    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();

        //Flight Tickets
        //key = From  ||  value = To
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        System.out.println(itineraryFromTickets(tickets));
    }
}
