import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] common = new int[26];

        // Count characters in the first word
        for (char c : words[0].toCharArray()) {
            common[c - 'a']++;
        }

        // Compare with the remaining words
        for (int i = 1; i < words.length; i++) {
            int[] freq = new int[26];

            for (char c : words[i].toCharArray()) {
                freq[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                common[j] = Math.min(common[j], freq[j]);
            }
        }

        // Build the result
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (common[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                common[i]--;
            }
        }

        return result;
    }
}
