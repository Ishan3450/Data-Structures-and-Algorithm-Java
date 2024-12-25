package Heaps;

import java.util.*;

public class LeetcodeIPO{
    private class Project {
        int profit;
        int capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap for storing only the profits

        Project[] projects = new Project[profits.length];
        for(int i = 0 ; i < profits.length ; i ++){
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects, (a,b) -> a.capital - b.capital);
        int idx = 0;

        while (k > 0) {
            while(idx < projects.length && projects[idx].capital <= w){
                pq.add(projects[idx].profit);
                idx ++;
            }

            if(pq.isEmpty()){
                break;
            }

            w += pq.remove();
            k--;
        }
        return w;
    }
}