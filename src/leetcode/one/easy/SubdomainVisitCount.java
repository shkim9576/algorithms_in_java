package leetcode.one.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public static void main(String[] args) {
        SubdomainVisitCount o = new SubdomainVisitCount();
        //[951 com, 900 google.mail.com, 1 intel.mail.com, 5 org, 5 wiki.org, 901 mail.com, 50 yahoo.com]
        System.out.println(o.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"})); //
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String cpdomain : cpdomains) {
            int spaceIndex = cpdomain.indexOf(' ');
            int clicks = Integer.valueOf(cpdomain.substring(0, spaceIndex));
            String domain = cpdomain.substring(spaceIndex + 1);
            sb.setLength(0);
            sb.append(domain);

            while (true) {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + clicks);
                int dotIndex = sb.indexOf(".");
                if (dotIndex == -1) break;
                sb.delete(0, dotIndex + 1);
            }
        }

        for (String domain : map.keySet()) {
            result.add(map.get(domain) + " " + domain);
        }

        return result;
    }
}
