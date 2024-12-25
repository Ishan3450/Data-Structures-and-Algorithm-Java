package Heaps;

import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    /*
     * Easy APproach
     */
    private class Station implements Comparable<Station>{
        int position;
        int fuel;

        Station(int position, int fuel){
            this.position = position;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(Station s){
            return this.fuel > s.fuel ? -1 : 1;
        }
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Station> pq = new PriorityQueue<>();
        int maxReach = startFuel;
        int refuelingCount = 0;
        int idx = 0;

        while(maxReach < target){
            while(idx < stations.length && stations[idx][0] <= maxReach){
                pq.add(new Station(stations[idx][0], stations[idx][1]));
                idx ++;
            }

            if(pq.isEmpty()){
                return -1;
            }

            maxReach += pq.peek().fuel;
            refuelingCount ++;
            pq.remove();
        }

        return refuelingCount;
    }
}

/*
 * Hard Approach
 */
class HardApproach{
    private class HeapNode implements Comparable<HeapNode> {
        int position;
        int fuel;

        HeapNode(int position, int fuel) {
            this.position = position;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(HeapNode h) {
            return this.fuel > h.fuel ? -1 : 1;
        }

        public String toString() {
            return this.position + " " + this.fuel;
        }
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<HeapNode> pq = new PriorityQueue<>();

        int stops = 0;
        int dist = 0;
        int fuel = startFuel;

        int idx = 0;

        while (idx < stations.length) {

            // 1. Add the stations till which we can reach with the current fuel
            while (idx < stations.length) {
                if (fuel >= Math.abs(stations[idx][0] - dist)) {
                    pq.add(new HeapNode(stations[idx][0], stations[idx][1]));
                    idx++;
                } else {
                    break;
                }
            }

            if (fuel >= (target - dist)) {
                return stops;
            }

            if (pq.isEmpty()) {
                return -1;
            }

            int travelledDist = pq.peek().position - dist;
            dist = pq.peek().position;
            fuel = Math.abs(travelledDist - fuel) + pq.peek().fuel;
            stops++;
            pq.remove();
        }

        if (fuel >= (target - dist)) {
            return stops;
        }

        while (!pq.isEmpty()) {
            int travelledDist = pq.peek().position - dist;
            dist = pq.peek().position;
            fuel = Math.abs(travelledDist - fuel) + pq.peek().fuel;
            stops++;
            pq.remove();

            if (fuel >= (target - dist)) {
                return stops;
            }
        }

        // not possible
        return -1;
    }

    // 2. New Dist will be pq.peek().dist
    // 3. New fuel will be (new dist - old dist) - prev fuel + pe.peek().fuel
    // 4. When fuel >- (Target - Dist) we got the ans
}