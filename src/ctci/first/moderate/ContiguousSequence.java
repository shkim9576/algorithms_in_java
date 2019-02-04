package ctci.first.moderate;

public class ContiguousSequence {
    public static void main(String[] args) {
        int[] A = {2, 3, -8, -1, 2, 4, -2, 3}; //7
        ContiguousSequence ob = new ContiguousSequence();
        System.out.println(ob.findMaxSum(A));
    }

    int findMaxSum(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i : A) {
            sum += i;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }
}
