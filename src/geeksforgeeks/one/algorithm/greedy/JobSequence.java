package geeksforgeeks.one.algorithm.greedy;

import java.util.Arrays;

public class JobSequence {
    // https://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/

    public static void main(String[] args) {
        JobSequence ob = new JobSequence();

        // output: c a e
        Job[] A = {new Job("a", 2, 100), new Job("b", 1, 19), new Job("c", 2, 27), new Job("d", 1, 25), new Job("e", 3, 15)};
        ob.jobSequencing(A);

        System.out.println("");

        // j2 j1 j3
        Job[] B = {new Job("j1", 2, 60), new Job("j2", 1, 100), new Job("j3", 3, 20), new Job("j4", 2, 40), new Job("j5", 1, 20)};
        ob.jobSequencing(B);
    }

    static class Job {
        int profit;
        int deadLine;
        String id;

        Job(String id, int deadLine, int profit) {
            this.id = id;
            this.profit = profit;
            this.deadLine = deadLine;
        }
    }

    void jobSequencing(Job[] jobs) {
        if (jobs == null || jobs.length == 0) return;
        Arrays.sort(jobs, (j1, j2) -> j2.profit - j1.profit);

        int n = jobs.length;
        Job[] slots = new Job[n];
        for (int i = 0; i < n; i++) {
            Job job = jobs[i]; // max profit job
            int freeSlotIndex = findFreeSlot(slots, job.deadLine);
            if (freeSlotIndex != -1) slots[freeSlotIndex] = job;
        }

        for (Job j : slots) {
            if (j != null) System.out.print(j.id + " ");
        }
    }

    int findFreeSlot(Job[] slots, int deadLine) {
        if (deadLine >= slots.length) return -1;
        for (int i = deadLine - 1; i >= 0; i--) {
            if (slots[i] == null) return i;
        }
        return -1;
    }

}
