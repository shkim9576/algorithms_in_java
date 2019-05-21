package geeksforgeeks.six.heap;

public class PrintLessThanK {

    public static void main(String[] args) {
        PrintLessThanK o = new PrintLessThanK();
        int[] A = {5, 1, 3, 4, 2, 2, 10, 15, 53, 100, 22, 11};
        o.printLessThanK(A, 10);
    }

    void printLessThanK(int[] A, int k) {
        buildHeap(A);

        printRec(A, 0, k);
    }

    void printRec(int[] A, int i, int k) {
        if (i >= A.length || A[i] > k) return;

        System.out.print(A[i] + " ");
        printRec(A, i * 2 + 1, k);
        printRec(A, i * 2 + 2, k);
    }

    void buildHeap(int[] A) {
        for (int i = (A.length / 2) - 1; i >= 0; i--) {
            heapify(A, A.length, i);
        }
    }

    void heapify(int[] A, int size, int i) {
        int smallest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < size && A[smallest] > A[left]) smallest = left;
        if (right < size && A[smallest] > A[right]) smallest = right;

        if (i != smallest) {
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            heapify(A, size, smallest);
        }
    }


}



