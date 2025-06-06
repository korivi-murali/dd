import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the number of moves
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Declare the array
        int[] nums = new int[n];

        // Input each move
        System.out.println("Enter " + n + " non-zero integers (positive for right, negative for left):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if (nums[i] == 0) {
                System.out.println("0 is not allowed. Please enter a non-zero integer.");
                i--;  // repeat this iteration
            }
        }

        // Call the method and print result
        int result = countReturnsToBoundary(nums);
        System.out.println("Number of times ant returns to boundary: " + result);
        
        scanner.close();
    }

    public static int countReturnsToBoundary(int[] nums) {
        int position = 0;
        int count = 0;

        for (int move : nums) {
            position += move;
            if (position == 0) {
                count++;
            }
        }

        return count;
    }
}
