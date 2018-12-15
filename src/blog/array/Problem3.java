package blog.array;

public class Problem3 {
    public static void main(String[] args) {
        Problem3 p = new Problem3();
        System.out.println(p.minimumSwaps(new int[]{4, 3, 1, 2}));
    }

    int minimumSwaps(int[] arr) {
        int swapCount = 0;
        int currIndex = 0;

        while (currIndex < arr.length - 1) {
            if (arr[currIndex] == currIndex + 1) {
                currIndex++;
            } else {
                swap(arr, currIndex, arr[currIndex] - 1);
                swapCount++;
            }
        }

        return swapCount;
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
