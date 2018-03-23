package g4g.string.excercise;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates ob = new RemoveDuplicates();
        System.out.println(ob.removeDuplicates("aCcaAaBbCCaACCCBcbbcc"));
    }

    String removeDuplicates(String S) {
        if (S == null || S.length() <= 1) return S;

        boolean[] flags = new boolean[256];
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (flags[c]) continue;
            sb.append(c);
            flags[c] = true;
        }

        return sb.toString();
    }

}
