import java.util.*;

public class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;

        // dp[i][j] = true if sum j is possible with first i elements
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 1; j <= target; j++) {
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }

        if (!dp[n][target]) return false;

        // Backtrack to find subset1 summing to target
        List<Integer> subset1 = new ArrayList<>();
        boolean[] chosen = new boolean[n];
        int i = n, j = target;
        while (i > 0 && j > 0) {
            if (dp[i - 1][j]) {
                // not included
                i--;
            } else {
                // included
                subset1.add(nums[i - 1]);
                chosen[i - 1] = true;
                j -= nums[i - 1];
                i--;
            }
        }

        // subset2 contains elements not chosen in subset1
        List<Integer> subset2 = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            if (!chosen[k]) {
                subset2.add(nums[k]);
            }
        }

        System.out.println("Subset 1 (sum " + target + "): " + subset1);
        System.out.println("Subset 2 (sum " + target + "): " + subset2);

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        boolean canPartition = solution.canPartition(nums);

        System.out.println("Can partition into two subsets with equal sum? " + canPartition);

        scanner.close();
    }
}
