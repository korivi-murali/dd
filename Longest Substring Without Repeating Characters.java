import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, maxLen = 0;
        int n = s.length();

        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c) + 1);
            }
            map.put(c, r);
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring(input);

        System.out.println("Length of longest substring without repeating characters: " + length);
        scanner.close();
    }
}
