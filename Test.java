import java.util.*;

public class Test {

    public static long minCostToCrazyBitstring(int n, String s, long[] a) {
        // Count the number of '0's and '1's
        int zeroCount = 0, oneCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeroCount++;
            else oneCount++;
        }

        // If the string is already a crazy-bitstring, return 0
        if (zeroCount == n || oneCount == n || zeroCount == oneCount) return 0;

        // Find the minimum cost by considering all possible transformations
        long minCost = Long.MAX_VALUE;
        long costOfZeroToOnes = 0, costOfOneToZeros = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                costOfZeroToOnes += a[i];
            } else {
                costOfOneToZeros += a[i];
            }
        }

        minCost = Math.min(costOfZeroToOnes, costOfOneToZeros);

        return minCost;
    }
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt(); // Number of test cases
//        while (t-- > 0) {
//            int n = scanner.nextInt(); // Length of the string
//            String s = scanner.next(); // Binary string
//            long[] a = new long[n]; // Array of costs
//            for (int i = 0; i < n; i++) {
//                a[i] = scanner.nextLong();
//            }
//
//            long result = minCostToCrazyBitstring(n, s, a);
//            System.out.println();
//            System.out.println(result);
//        }
//        scanner.close();
        Map<Integer,Integer> m = new HashMap<>();

    }
}