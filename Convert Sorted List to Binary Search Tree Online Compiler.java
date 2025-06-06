import java.util.*;

public class Main {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Definition for a binary tree node.
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
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null) return null;
            if(head.next == null) return new TreeNode(head.val);

            ListNode slow = head, fast = head, slowPrev = null;
            while(fast != null && fast.next != null) {
                slowPrev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            TreeNode root = new TreeNode(slow.val);
            if(slowPrev != null) slowPrev.next = null; // break left part

            root.left = sortedListToBST(head == slow ? null : head);
            root.right = sortedListToBST(slow.next);

            return root;
        }

        // Print tree in level order with nulls to show structure
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

            // Remove trailing "null"s
            int i = result.size() - 1;
            while (i >= 0 && result.get(i).equals("null")) {
                result.remove(i);
                i--;
            }

            return result;
        }
    }

    // Helper: build linked list from array
    public static ListNode buildList(int[] nums) {
        if(nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for(int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-10, -3, 0, 5, 9};
        ListNode head = buildList(nums);

        TreeNode bstRoot = solution.sortedListToBST(head);

        List<String> serializedTree = solution.serialize(bstRoot);
        System.out.println(serializedTree);
        // Expected output: [0, -10, 5, null, -3, null, 9]
    }
}
