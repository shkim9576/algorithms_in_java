package geeksforgeeks.one.algorithm.greedy;

public class MaxEqualSum3Stacks {
    // https://www.geeksforgeeks.org/find-maximum-sum-possible-equal-sum-three-stacks/

    public static void main(String[] args) {
        int stack1[] = {3, 2, 1, 1, 1};
        int stack2[] = {4, 3, 2};
        int stack3[] = {1, 1, 4, 1};

        MaxEqualSum3Stacks ob = new MaxEqualSum3Stacks();
        System.out.println(ob.findMaxEqualSum3Stacks(stack1, stack2, stack3));
    }

    int findMaxEqualSum3Stacks(int[] arr1, int[] arr2, int[] arr3) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int top1 = 0;
        int top2 = 0;
        int top3 = 0;

        for (int i : arr1) sum1 += i;
        for (int i : arr2) sum2 += i;
        for (int i : arr3) sum3 += i;

        while (top1 < arr1.length && top2 < arr2.length && top3 < arr3.length && !isSame(sum1, sum2, sum3)) {
            if (sum1 >= sum2 && sum1 >= sum3) sum1 -= arr1[top1++];
            else if (sum2 >= sum1 && sum2 >= sum3) sum2 -= arr2[top2++];
            else sum3 -= arr3[top3++];
        }

        return isSame(sum1, sum2, sum3) ? sum1 : 0;
    }

    boolean isSame(int i1, int i2, int i3) {
        return i1 == i2 && i2 == i3;
    }

}
