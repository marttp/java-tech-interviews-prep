package lc.general;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate_1507 {

  public String reformatDate(String date) {
    Map<String, String> monthMap = createMonthMap();
    StringBuilder sb = new StringBuilder();
    String[] splitTxt = date.split("\\s+");

    // Put year at first -> after with month
    sb.append(splitTxt[2])
        .append('-')
        .append(monthMap.get(splitTxt[1]));
    String dayTxt = splitTxt[0];
    // Cut suffix => st, nd, rd, th
    String dayDigit = dayTxt.substring(0, dayTxt.length() - 2);
    if (dayDigit.length() == 1) {
      sb.append('0');
    }
    sb.append(dayDigit);
    return sb.toString();
  }

  private Map<String, String> createMonthMap() {
    Map<String, String> map = new HashMap<>();
    map.put("Jan", "01");
    map.put("Feb", "02");
    map.put("Mar", "03");
    map.put("Apr", "04");
    map.put("May", "05");
    map.put("Jun", "06");
    map.put("Jul", "07");
    map.put("Aug", "08");
    map.put("Sep", "09");
    map.put("Oct", "10");
    map.put("Nov", "11");
    map.put("Dec", "12");
    return map;
  }
}
