package lc.general;

public class Integer2Roman_12 {

  private static final String[] thousands = {"", "M", "MM", "MMM"}; // 3999 max
  private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC",
      "CM"};
  private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
  private static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

  public String intToRoman(int num) {
    return thousands[num / 1000] +
        hundreds[num % 1000 / 100] +
        tens[num % 100 / 10] +
        ones[num % 10];
  }
}
