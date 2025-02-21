package greedyAlgorithms;

public class SurvivalOnIsland {

    public int minimumDays(int totalDays, int maxFoodPerDay, int dailyFoodRequirement) {

        if (dailyFoodRequirement > maxFoodPerDay) return -1;

        // Check if survival is impossible due to Sundays
        if ((totalDays >= 7) && (((maxFoodPerDay - dailyFoodRequirement) * 6) < dailyFoodRequirement))
            return -1;

        int totalFoodNeeded = totalDays * dailyFoodRequirement;

        // Calculate minimum days to buy food
        if (totalFoodNeeded % maxFoodPerDay == 0) {
            return totalFoodNeeded / maxFoodPerDay;
        } else {
            return (totalFoodNeeded / maxFoodPerDay) + 1;  // Ceiling division
        }
        //Time  Complexity - O(1)
        //Space Complexity - O(1)
    }
    //https://www.geeksforgeeks.org/problems/check-if-it-is-possible-to-survive-on-island4922/1
}
