package lc.general;

public class IntegerToEnglishWords_273 {

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    // Split each case billion, million, thousand, lower than thousand (hundred, ty-teen, digit)
    int billion = num / 1_000_000_000;
    int million = (num - billion * 1_000_000_000) / 1_000_000;
    int thousand = (num - billion * 1_000_000_000 - million * 1_000_000) / 1000;
    int rest = num - billion * 1_000_000_000 - million * 1_000_000 - thousand * 1000;
    StringBuilder sb = new StringBuilder();
    manageString(sb, billion, "Billion");
    manageString(sb, million, "Million");
    manageString(sb, thousand, "Thousand");
    manageString(sb, rest, "");
    return sb.toString();
  }

  private void manageString(StringBuilder sb, int num, String suffix) {
    if (num != 0) {
      if (!sb.isEmpty()) {
        // In case it's not the first prefix => Add space to split
        sb.append(" ");
      }
      sb.append(Translator.threeDigits(num));
      // billion, million, thousand => ถ้ามีค่า ส่งผลให้ sb ไม่ empty แน่นอน
      if (!sb.isEmpty() && !suffix.isEmpty()) {
        sb.append(" ")
            .append(suffix);
      }
    }
  }

  private static class Translator {

    public static String ones(int fare) {
      return switch (fare) {
        case 1 -> "One";
        case 2 -> "Two";
        case 3 -> "Three";
        case 4 -> "Four";
        case 5 -> "Five";
        case 6 -> "Six";
        case 7 -> "Seven";
        case 8 -> "Eight";
        case 9 -> "Nine";
        default -> "";
      };
    }

    public static String teens(int fare) {
      return switch (fare) {
        case 10 -> "Ten";
        case 11 -> "Eleven";
        case 12 -> "Twelve";
        case 13 -> "Thirteen";
        case 14 -> "Fourteen";
        case 15 -> "Fifteen";
        case 16 -> "Sixteen";
        case 17 -> "Seventeen";
        case 18 -> "Eighteen";
        case 19 -> "Nineteen";
        default -> "";
      };
    }

    public static String tens(int fare) {
      return switch (fare) {
        case 2 -> "Twenty";
        case 3 -> "Thirty";
        case 4 -> "Forty";
        case 5 -> "Fifty";
        case 6 -> "Sixty";
        case 7 -> "Seventy";
        case 8 -> "Eighty";
        case 9 -> "Ninety";
        default -> "";
      };
    }

    public static String twoDigits(int fare) {
      if (fare == 0) {
        return "";
      } else if (fare < 10) {
        return ones(fare);
      } else if (fare < 20) {
        return teens(fare);
      }
      int tenner = fare / 10;
      int remainder = fare % 10;
      if (remainder > 0) {
        return tens(tenner) + " " + ones(remainder);
      }
      return tens(tenner);
    }

    public static String threeDigits(int fare) {
      int hundred = fare / 100;
      int rest = fare - (hundred * 100);
      // ถ้ามันไม่เท่ากับ 0 ก็แปลว่า ไม่มีตัวได้ตัวนึงเป็น 0
      if (hundred * rest != 0) {
        return ones(hundred) + " Hundred " + twoDigits(rest);
      } else if (hundred == 0) { // ใส่แค่ twoDigits
        return twoDigits(rest);
      } else if (rest == 0) { // ใส่แค่ ones บวกเติม hundred
        return ones(hundred) + " Hundred";
      }
      return "";
    }
  }
}
