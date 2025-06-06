import java.util.*;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int left, int right) {
            if (left > right) return null;
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid - 1);
            root.right = helper(nums, mid + 1, right);
            return root;
        }

        // Level order traversal that outputs the tree including nulls
        public List<String> serialize(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    result.add("null");
                    continue;
                }
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }

            // Remove trailing "null"s for cleaner output (optional)
            int i = result.size() - 1;
            while (i >= 0 && result.get(i).equals("null")) {
                result.remove(i);
                i--;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);

        List<String> serializedTree = solution.serialize(root);
        System.out.println(serializedTree);
        // Expected output: [0, -10, 5, null, -3, null, 9]
    }
}
