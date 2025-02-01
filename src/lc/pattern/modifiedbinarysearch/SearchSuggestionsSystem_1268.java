package lc.pattern.modifiedbinarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem_1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        StringBuilder searchKeyword = new StringBuilder();
        List<List<String>> result = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            searchKeyword.append(c);
            String keyword = searchKeyword.toString();
            List<String> subResult = new ArrayList<>();
            int left = 0;
            int right = products.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // Compare to find lower bound (already sorted?)
                if (products[mid].compareTo(keyword) < 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            for (int i = left; i < left + 3 && i < products.length; i++) {
                if (!products[i].startsWith(keyword)) {
                    break;
                }
                subResult.add(products[i]);
            }
            result.add(subResult);
        }
        return result;
    }

}
