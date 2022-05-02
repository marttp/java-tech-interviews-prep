package additional;

public class KMPAlgorithms {

  public boolean knuthMorrisPrattAlgorithm(String strs, String substring) {
    int m = strs.length();
    int n = substring.length();
    int[] lps = new int[n];
    computeLPSArray(substring, n, lps);

    int i = 0; // for strs
    int j = 0; // for substring

    while (i < m) {
      if (strs.charAt(i) == substring.charAt(j)) {
        i++;
        j++;
      }
      if (j == n) {
        // We found this pattern in txt string
        return true;
      } else if (i < m && strs.charAt(i) != substring.charAt(j)) {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return false;
  }

  private void computeLPSArray(String pattern, int n, int[] lps) {
    int len = 0;
    int i = 0;
    lps[0] = 0;
    while (i < n) {
      // split to 2 case - match, mismatch
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i++] = len;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i++] = len; // if fall to this case, len == 0
        }
      }
    }
  }
}
