package Greedy;

public class CheckIfItIsPossibleToSurviveOnIsland {
    static int minimumDays(int S, int N, int M) {
        int totalSundays = S / 7;
        int daysWeCanBuyFood = S - totalSundays;

        int ans = 0;

        int totalFoodRequired = S * M;

        if (totalFoodRequired % N == 0) {
            ans = totalFoodRequired / N;
        } else {
            ans = (totalFoodRequired / N) + 1;
        }

        if (ans <= daysWeCanBuyFood)
            return ans;
        return -1; // not possible
    }
}