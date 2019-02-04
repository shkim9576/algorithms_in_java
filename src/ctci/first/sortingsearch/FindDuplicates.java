package ctci.first.sortingsearch;

public class FindDuplicates {

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 9, 10, 2, 4, 6, 8, 1000, 2134, 7, 5}; // 5
        FindDuplicates ob = new FindDuplicates();
        System.out.println(ob.findDuplicate(A));
    }

    int findDuplicate(int[] A) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (bs.get(num)) {
                return num;
            } else {
                bs.set(num);
            }
        }
        return -1; // not found
    }


    class BitSet {
        int[] bitset;

        public BitSet(int size) {
            bitset = new int[size >> 5 + 1]; // divide by 32
        }

        boolean get(int pos) {
            int wordNumber = pos >> 5;  // divide by 32
            int bitNumber = pos & 0x1F;  // mod 32
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;
        }

        void set(int pos) {
            int wordNumber = pos >> 5;
            int bitNumber = pos & 0x1F;
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }


}
