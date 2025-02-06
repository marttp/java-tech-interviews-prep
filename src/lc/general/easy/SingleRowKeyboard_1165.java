package lc.general.easy;

public class SingleRowKeyboard_1165 {
    public int calculateTime(String keyboard, String word) {
        int[] index = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            char c = keyboard.charAt(i);
            index[c - 'a'] = i;
        }
        int move = 0;
        int current = 0;
        for (char c : word.toCharArray()) {
            move += Math.abs(index[c - 'a'] - current);
            current = index[c - 'a'];
        }
        return move;
    }
}
