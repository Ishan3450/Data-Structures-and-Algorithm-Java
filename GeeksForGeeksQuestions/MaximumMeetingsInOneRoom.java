// https://www.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaximumMeetingsInOneRoom {
    private static class Pair {
        int startingTime;
        int finishingTime;
        int meetingNumber;

        Pair(int startingTime, int finishingTime, int meetingNumber) {
            this.startingTime = startingTime;
            this.finishingTime = finishingTime;
            this.meetingNumber = meetingNumber;
        }
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        Pair[] pairs = new Pair[S.length];

        for (int i = 0; i < S.length; i++) {
            pairs[i] = new Pair(S[i], F[i], i + 1);
        }

        Comparator<Pair> comparator = new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.finishingTime - p2.finishingTime;
            }
        };
        Arrays.sort(pairs, comparator);

        ArrayList<Integer> meetingNumbers = new ArrayList<>();
        meetingNumbers.add(pairs[0].meetingNumber);

        Pair prevPair = pairs[0];

        for (int i = 1; i < pairs.length; i++) {
            Pair currPair = pairs[i];

            if (currPair.startingTime > prevPair.finishingTime) {
                meetingNumbers.add(currPair.meetingNumber);
                prevPair = currPair;
            }
        }

        Collections.sort(meetingNumbers);
        return meetingNumbers;
    }
}
