package lc.general;

import java.util.Arrays;

public class MaximumAreaPieceOfCakeAfterHorizontalVerticalCuts_1465 {

  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    // Sort cut point ASC, so we can manage them easier
    Arrays.sort(horizontalCuts); // O(h log(h))
    Arrays.sort(verticalCuts); // O(v log(v))

    int hLen = horizontalCuts.length;
    int vLen = verticalCuts.length;

    // ความกว้าง ระหว่าง เส้นตัดแนวนอนแรกกับขอบ แนวตั้งส่วนบน vs เส้นตัดแนวนอนสุดท้ายกับขอบ แนวตั้งส่วนล่าง
    long maxH = Math.max(horizontalCuts[0], h - horizontalCuts[hLen - 1]);
    for (int i = 1; i < hLen; i++) {
      // ในระหว่างเส้นตัด มีตัวไหนที่มันมากกว่าไอตัว initial ของเราอีกมั้ย
      maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
    }
    // ความกว้าง ระหว่าง เส้นตัดแนวตั้งแรกกับขอบ แนวนอนด้านซ้าย vs เส้นตัดแนวตั้งสุดท้ายกับขอบ แนวนอนด้านขวา
    long maxW = Math.max(verticalCuts[0], w - verticalCuts[vLen - 1]);
    for (int i = 1; i < vLen; i++) {
      // ในระหว่างเส้นตัด มีตัวไหนที่มันมากกว่าไอตัว initial ของเราอีกมั้ย
      maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
    }
    return (int) ((maxH * maxW) % 1000000007);
  }
}
