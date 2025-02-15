package lc.pattern.backtracking;

public class FindThePunishmentNumberOfAnInteger_2698 {

    public int punishmentNumber(int n) {
        int result = 0;
        for (int num = 1; num <= n; num++) {
            int square = num * num;
            if (canPartition(String.valueOf(square), num)) {
                result += square;
            }
        }
        return result;
    }

    private boolean canPartition(String numText, int target) {
        return canPartition(numText, 0, target);
    }

    private boolean canPartition(String numText, int currentIndex, int target) {
        if (currentIndex == numText.length()) {
            return target == 0;
        }
        for (int index = currentIndex + 1; index <= numText.length(); index++) {
            int partitionedNum = Integer.parseInt(numText.substring(currentIndex, index));
            if (canPartition(numText, index, target - partitionedNum)) {
                return true;
            }
        }
        return false;
    }
}
