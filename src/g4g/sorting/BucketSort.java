package g4g.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    //https://www.geeksforgeeks.org/bucket-sort-2/

    public static void main(String[] args) {
        Double arr[] = {0.1234, 0.565, 0.3434, 0.897, 0.656, 0.565, 0.665};
        BucketSort ob = new BucketSort();
        ob.bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void bucketSort(Double[] A) {
        if (A == null || A.length == 0) return;

        // step 1 - create a list of bucket.
        LinkedList<Double>[] buckets = new LinkedList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        // step 2 - put each input element to the bucket
        for (int i = 0; i < A.length; i++) {
            int hash = hash(A[i]);
            buckets[hash].add(A[i]);
        }

        // step 3 - sort each bucket
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);
        }

        // step 4 - combine buckets
        int ai = 0;
        for (int i = 0; i < buckets.length; i++) {
            List<Double> list = buckets[i];
            for (Double n : list) A[ai++] = n;
        }
    }

    int hash(Double f) {
        return (int) (f * 10);
    }

}
