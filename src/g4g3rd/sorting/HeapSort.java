package g4g3rd.sorting;

public class HeapSort {

    public class MaxHeap {

        private int maxSize;
        private int[] A;
        private int currentIndex = 1;
        private int size;

        public MaxHeap(int maxSize) {
            A = new int[maxSize+1];
        }

        public int getLeft(int position) {
            return A[position*2];
        }

        public int getRight(int position) {
            return A[position*2 + 1];
        }

        public int getParent(int position) {
            return A[position/2];
        }

        public boolean isLeaf(int position) {
            return (size/2 < position);
        }

        public void insert(int data) {
            if (maxSize > currentIndex-1) {
                A[currentIndex++] = data;
                heapify(A, currentIndex-1, currentIndex);
            }
        }

        public int remove() {
            if(currentIndex >= 1) {
                int temp = A[1];
                A[1] = A[currentIndex--];
                heapify(A, currentIndex-1, currentIndex);
                return temp;
            }
            return -1;
        }

        private void heapify(int[] A, int size, int position) {
            int maxPosition = position;
            if (A[position] < getLeft(position)) {
                maxPosition = position * 2;
            } else if (A[position] < getRight(position)) {
                maxPosition = position * 2 + 1;
            }

            swap(A, position, maxPosition);
            heapify(A, size, maxPosition);
        }

        private void swap(int[] A, int x, int y) {
            int temp = A[x];
            A[x] = A[y];
            A[y] = temp;
        }
    }


}
