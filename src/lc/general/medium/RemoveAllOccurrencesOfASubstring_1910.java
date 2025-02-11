package lc.general.medium;

public class RemoveAllOccurrencesOfASubstring_1910 {
    public String removeOccurrences(String s, String part) {
        String result = s;
        int indexOfPart = s.indexOf(part);
        while (indexOfPart != -1) {
            int length = part.length();
            result = result.substring(0, indexOfPart) +
                    result.substring(indexOfPart + length);
            indexOfPart = result.indexOf(part);
        }
        return result;
    }
}
