package leetcode.one.easy;

//https://leetcode.com/problems/excel-sheet-column-title/
public class ExcelSheetColumnTile {

    public static void main(String[] args) {
        ExcelSheetColumnTile o = new ExcelSheetColumnTile();
        System.out.println(o.convertToTitle(28)); //AB
        System.out.println(o.convertToTitle(3)); //C
    }

    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
    }
}
