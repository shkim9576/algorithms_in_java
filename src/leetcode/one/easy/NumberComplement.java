package leetcode.one.easy;

//https://leetcode.com/problems/number-complement/submissions/
public class NumberComplement {

    public static void main(String[] args) {
        NumberComplement o = new NumberComplement();
        System.out.println(o.findComplement(5)); //2
    }

    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
