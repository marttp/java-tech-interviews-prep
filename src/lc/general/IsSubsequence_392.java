package lc.general;

public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) {
            return false;
        }
        int si = 0;
        int ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }
            ti++;
        }
        return si == s.length();
    }

}
