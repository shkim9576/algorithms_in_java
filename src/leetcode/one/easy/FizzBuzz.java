package leetcode.one.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/fizz-buzz/
public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz o = new FizzBuzz();
        System.out.println(o.fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }
}
