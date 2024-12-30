package datastructurealgorithms.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BacktrackingExample {

    public static void main(String[] args) {
        subset();
        System.out.println();
        phoneLetterCombination();
    }

    private static void subset() {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = List.of(1, 2, 3);
        backtrackSubset(list, 0, result, new LinkedList<>());
        System.out.println("Subsets: " + result);
    }

    private static void backtrackSubset(
            List<Integer> list, int index, List<List<Integer>> result, LinkedList<Integer> currentState) {
        result.add(new ArrayList<>(currentState));
        for (int i = index; i < list.size(); i++) {
            currentState.add(list.get(i));
            backtrackSubset(list, i + 1, result, currentState);
            currentState.removeLast();
        }
    }

    private static void phoneLetterCombination() {
        List<String> result = new ArrayList<>();
        String digits = "23";
        backtrackLetterCombination(digits, 0, result, new StringBuilder());
        System.out.println("phoneLetterCombination: " + result);
    }

    private static void backtrackLetterCombination(
            String digits, int index, List<String> result, StringBuilder currentState) {
        if (index == digits.length()) {
            result.add(currentState.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String possibleChars = getPad(digit);
        for (char c : possibleChars.toCharArray()) {
            currentState.append(c);
            backtrackLetterCombination(digits, index + 1, result, currentState);
            currentState.deleteCharAt(currentState.length() - 1);
        }
    }

    private static String getPad(int d) {
        return switch (d) {
            case 2 -> "abc";
            case 3 -> "def";
            case 4 -> "ghi";
            case 5 -> "jkl";
            case 6 -> "mno";
            case 7 -> "pqrs";
            case 8 -> "tuv";
            case 9 -> "wxyz";
            default -> "";
        };
    }
}
