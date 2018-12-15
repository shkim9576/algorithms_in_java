package geeksforgeeks.one.hash.excercise;

public class MaxOccurringChar {
    // https://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/

    public static void main(String[] args) {
        String str = "sample geeksforgeeks.g4g1st.one.string";
        MaxOccurringChar ob = new MaxOccurringChar();
        char result = ob.getMaxOccuringChar(str);
        System.out.println("Max occurring character is " + result);
    }

    char getMaxOccuringChar(String s) {
        if (s == null || s.length() == 0) return ' ';

        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int max = -1;
        char result = ' ';
        for (char c : s.toCharArray()) {
            if (count[c] > max) {
                max = count[c];
                result = c;
            }
        }

        return result;
    }

}
