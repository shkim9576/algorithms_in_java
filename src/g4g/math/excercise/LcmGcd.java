package g4g.math.excercise;

public class LcmGcd {
    // https://www.geeksforgeeks.org/c-program-find-lcm-two-numbers/

    public static void main(String[] args) {
        int a = 15;
        int b = 20;

        LcmGcd ob = new LcmGcd();
        System.out.println("gcd : " + ob.gcd(a, b));
        System.out.println("lcm : " + ob.lcm(a, b));
    }

    int lcm(int a, int b) {
        // a * b = LCM(a,b) * GCD(a,b);
        return (a * b) / gcd(a, b);
    }

    int gcd(int a, int b) {
        if (a == 0 || b == 0) return 0;
        if (a == b) return a;

        return a > b ? gcd(a - b, b) : gcd(a, b - a);
    }

}
