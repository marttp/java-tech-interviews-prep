package lc.general;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        while (ai >= 0 || bi >= 0) {
            int aNumber = ai >= 0 ? Character.getNumericValue(a.charAt(ai--)) : 0;
            int bNumber = bi >= 0 ? Character.getNumericValue(b.charAt(bi--)) : 0;
            int sum = aNumber + bNumber + carry;
            carry = sum / 2;
            sum = sum % 2;
            sb.insert(0, sum);
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
