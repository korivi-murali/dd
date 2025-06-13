import java.util.*;

public class Solution {

    public void findSubsetsWithSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, target, new ArrayList<>(), result);

        System.out.println("Number of subsets with sum " + target + ": " + result.size());
        System.out.println("Subsets:");

        for (List<Integer> subset : result) {
            System.out.println(formatSubset(subset, target));
        }
    }

    private void backtrack(int[] nums, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index == nums.length) {
            return;
        }

        // Include nums[index]
        current.add(nums[index]);
        backtrack(nums, index + 1, target - nums[index], current, result);
        current.remove(current.size() - 1);

        // Exclude nums[index]
        backtrack(nums, index + 1, target, current, result);
    }

    private String formatSubset(List<Integer> subset, int target) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subset.size(); i++) {
            sb.append(subset.get(i));
            if (i != subset.size() - 1) {
                sb.append(" + ");
            }
        }
        sb.append(" = ").append(target);
        return sb.toString();
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

        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();

        Solution solution = new Solution();
        solution.findSubsetsWithSum(nums, target);

        scanner.close();
    }
}
