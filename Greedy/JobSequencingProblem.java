package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem {
    private class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Comparator<Job> sortByProfitInDescending = new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                if (j2.profit == j1.profit)
                    return j2.deadline - j1.deadline;
                return j2.profit - j1.profit;
            }
        };
        Arrays.sort(arr, sortByProfitInDescending);

        int[] jobs = new int[n + 1];

        for (Job job : arr) {
            if (jobs[job.deadline] != 0) {
                // means a job is already scheduled there
                // so we can schedule curr job before this deadline
                // means: if deadline is 3 means this job must be executed within 3 unit of time
                // after that it will be expired
                // so we will search from 1 till 3 that if possible to get smaller profit job
                // than currjob profit then we can put this job to that place

                for (int i = job.deadline - 1; i >= 1; i--) { // we will place the first place we got empty and not
                                                              // checking for min profit as we already sorted array in
                                                              // descending by profit
                    if (jobs[i] == 0) {
                        jobs[i] = job.profit;
                        break;
                    }
                }

            } else { // no job placed at this deadline then we can place it
                jobs[job.deadline] = job.profit;
            }
        }

        int jobsCount = 0;
        int totalProfit = 0;
        for (int jobProfit : jobs) {
            if (jobProfit != 0) {
                jobsCount++;
                totalProfit += jobProfit;
            }
        }

        return new int[] { jobsCount, totalProfit };
    }
}
