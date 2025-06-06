import java.util.*;

class TreeNode {
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

public class Main {
    public static void main(String[] args) {
        // Input: Skewed BST: 1 -> 2 -> 3 -> 4
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        Solution solution = new Solution();
        TreeNode balancedRoot = solution.balanceBST(root);

        // Print level-order output as array with nulls
        List<String> output = levelOrderWithNulls(balancedRoot);
        System.out.println(output);
    }

    // Helper to do level-order traversal including nulls
    public static List<String> levelOrderWithNulls(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
                continue;
            }
            result.add(String.valueOf(node.val));
            queue.add(node.left);
            queue.add(node.right);
        }

        // Remove trailing nulls for cleaner output (optional)
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i--);
        }

        return result;
    }
}

class Solution {
    List<TreeNode> sortedArr = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedArr.size() - 1);
    }

    void inorderTraverse(TreeNode root) {
        if (root == null) return;
        inorderTraverse(root.left);
        sortedArr.add(root);
        inorderTraverse(root.right);
    }

    TreeNode sortedArrayToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(sortedArr.get(mid).val);
        node.left = sortedArrayToBST(start, mid - 1);
        node.right = sortedArrayToBST(mid + 1, end);
        return node;
    }
}
