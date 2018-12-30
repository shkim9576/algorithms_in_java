package leetcode.one.easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/unique-email-addresses/
public class UniqueEmailAddresses {

    public static void main(String[] args) {
        UniqueEmailAddresses o = new UniqueEmailAddresses();
        System.out.println(o.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"})); //2
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String local = email.substring(0, email.indexOf("@"));
            String localBeforePlus = local.substring(0, email.indexOf("+"));
            String unique = localBeforePlus.replace(".", "") + email.substring(email.indexOf("@"));

            set.add(unique);
        }

        return set.size();
    }
}
