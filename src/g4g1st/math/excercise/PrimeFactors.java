package g4g1st.math.excercise;

public class PrimeFactors {
    // https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/

    public static void main(String[] args) {
        int n = 315; // 3 3 5 7

        PrimeFactors ob = new PrimeFactors();
        ob.primeFactors(n);
    }

    void primeFactors(int n) {

        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        if (n > 2) System.out.print(n);
    }

}
