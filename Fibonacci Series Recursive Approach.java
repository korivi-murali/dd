import java.util.Scanner;

public class Solution {
    private int[] memo;

    public int fib(int n) {
        memo = new int[n + 1];
        return fibMemo(n);
    }

    private int fibMemo(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.fib(n);
        System.out.println("Fibonacci number at position " + n + " is " + result);
        
        scanner.close();
    }
}
