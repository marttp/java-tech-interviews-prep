package lc.general.easy;

public class PerformStringShifts_1427 {

    public String stringShift(String s, int[][] shift) {
        // Left shift => right
        // Right shift => left
        // sub str1 + sub str 2
        int length = s.length();
        int index = 0;
        for (var command : shift) {
            index += command[0] == 0 ? command[1] : -command[1];
        }
        index %= length;
        if (index < 0) {
            index += length;
        }
        return s.substring(index) + s.substring(0, index);
    }

}
