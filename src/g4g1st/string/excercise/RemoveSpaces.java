package g4g1st.string.excercise;

public class RemoveSpaces {
    // https://www.geeksforgeeks.org/remove-spaces-from-a-given-string/

    public static void main(String[] args) {
        RemoveSpaces ob = new RemoveSpaces();
        System.out.println(ob.removeSpaces("   g  eeks   for ge  eeks  "));
    }

    String removeSpaces(String str) {
        if (str == null) return str;

        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') chars[count++] = chars[i];
        }

        return new String(chars).substring(0, count);
    }

}
