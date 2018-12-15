package geeksforgeeks.one.algorithm.dp;

public class NCRP {
    // https://www.geeksforgeeks.org/compute-ncr-p-set-1-introduction-and-dynamic-programming-solution/

    public static void main(String[] args) {
        NCRP ob = new NCRP();
        System.out.println(ob.ncrp(10,2,13)); // 6
    }

    double factorial(int n) {

        if (n <= 0) return 0;
        double sum = 1;
        for (int i=2; i<=n; i++) {
            sum *= i;
        }

        return sum;
    }
    
    double ncrp(int n, int r, int p) {

        double result = factorial(n) / (factorial(r) * factorial(n-r));
        return result % p;
    }

}
