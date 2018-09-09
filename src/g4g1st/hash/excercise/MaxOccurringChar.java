package g4g1st.hash.excercise;

public class MaxOccurringChar {
    // https://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/

    public static void main(String[] args) {
        String str = "sample g4g1st.string";
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
