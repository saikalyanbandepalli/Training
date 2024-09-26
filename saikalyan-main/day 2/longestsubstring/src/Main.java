import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        String s = "aabbccddeeffgghhiijj";
        String longestSubstr = findLongestSubstring(s);
        System.out.println(longestSubstr);
    }

    public static String findLongestSubstring(String str) {
        int n = str.length();
        int start = 0, maxLen = 0, startIndex = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < n; end++) {
            char currentChar = str.charAt(end);

            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }

            map.put(currentChar, end);

            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                startIndex = start;
            }
        }

        return str.substring(startIndex, startIndex + maxLen);
    }
}
