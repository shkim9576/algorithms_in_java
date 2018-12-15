package geeksforgeeks.one.algorithm.greedy;

public class MaxBusStations {
    // https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000}; // 3

        MaxBusStations ob = new MaxBusStations();
        System.out.println(ob.getNeededtation(arr, dep));
    }

    int getNeededtation(int[] arr, int[] dep) {
        int n = arr.length;
        int[] merged = new int[n * 2];
        int ai = 0;
        int di = 0;
        int mi = 0;
        int needed = 0;
        int max = Integer.MIN_VALUE;

        while (ai < n && di < n) {
            if (arr[ai] < dep[di]) {
                merged[mi++] = arr[ai++];
                needed++;
                max = Math.max(max, needed);
            } else {
                merged[mi++] = dep[di++];
                needed--;
            }
        }

        while (ai < n) {
            merged[mi++] = arr[ai++];
            needed++;
            max = Math.max(max, needed);
        }

        return max;
    }

}
