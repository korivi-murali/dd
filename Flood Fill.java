import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix size
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] image = new int[m][n];
        // Read image matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        // Read starting row, column and new color
        int sr = scanner.nextInt();
        int sc = scanner.nextInt();
        int newColor = scanner.nextInt();

        scanner.close();

        Solution solution = new Solution();
        int[][] result = solution.floodFill(image, sr, sc, newColor);

        // Print the resulting image
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int change = image[sr][sc];
        if (change != color) {
            fill(image, sr, sc, color, change);
        }
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int org) {
        int m = image.length, n = image[0].length;
        if (sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] != org) {
            return;
        }
        image[sr][sc] = color;
        for (int[] di : dir) {
            fill(image, sr + di[0], sc + di[1], color, org);
        }
    }
}
