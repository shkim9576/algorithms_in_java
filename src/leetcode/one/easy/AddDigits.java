package leetcode.one.easy;

//https://leetcode.com/problems/add-digits/
public class AddDigits {

    public static void main(String[] args) {
        AddDigits o = new AddDigits();
        System.out.println(o.addDigits(38)); //2
    }

    public int addDigits(int num) {
        int sum = num;
        while (sum > 9) {
            sum = sum % 10 + sum / 10;
        }

        return sum;
    }
}
