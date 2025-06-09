import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of people (N)
        System.out.print("Enter number of people (N): ");
        int N = scanner.nextInt();

        // Read number of trust pairs (T)
        System.out.print("Enter number of trust relationships: ");
        int T = scanner.nextInt();

        int[][] trust = new int[T][2];
        System.out.println("Enter the trust relationships (a b):");
        for (int i = 0; i < T; i++) {
            trust[i][0] = scanner.nextInt();
            trust[i][1] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int judge = solution.findJudge(N, trust);

        if (judge == -1) {
            System.out.println("No town judge found.");
        } else {
            System.out.println("The town judge is: " + judge);
        }
    }
}

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for (int[] t : trust) {
            count[t[0]]--;  // person trusts someone
            count[t[1]]++;  // person is trusted
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;  // found the judge
        }
        return -1;  // no judge found
    }
}
