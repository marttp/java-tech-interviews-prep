package lc.general.easy;

import java.util.List;
import java.util.Set;

public class SentenceSimilarity_734 {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        for (int i = 0; i < sentence1.length; i++) {
            String s1 = sentence1[i];
            String s2 = sentence2[i];
            if (!s1.equals(s2)) {
                if (similarPairs.isEmpty()) {
                    return false;
                }
                boolean isFoundMatch = false;
                for (var similar : similarPairs) {
                    var set = Set.of(similar.get(0), similar.get(1));
                    if (set.contains(s1) && set.contains(s2)) {
                        isFoundMatch = true;
                        break;
                    }
                }
                if (!isFoundMatch) {
                    return false;
                }
            }
        }
        return true;
    }

}
