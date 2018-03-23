package g4g.search.excercise;

public class FindMissingOne {
    // https://www.geeksforgeeks.org/find-the-missing-number/

    public static void main(String[] args) {
        int[] A = {1,3,2,4,6,7,8}; // 5

        FindMissingOne ob = new FindMissingOne();
        System.out.println(ob.find(A, 8));
        System.out.println(ob.findXOR(A, 8));
    }

    int find(int[] A, int n) {
        int sum = n * (n+1) / 2;
        for (int i : A) sum -= i;
        return sum;
    }

    int findXOR(int[] A, int n) {
        int xor = 0;
        for (int i=1; i<=n; i++) xor ^= i;
        for (int i : A) xor ^= i;
        return xor;
    }

}
