import java.util.Scanner;
import java.util.Arrays;
class Main{
    public static int lcsuf(String s1, String s2, int m, int n){
        if (m ==0 || n ==0 || s1.charAt(m - 1) != s2.charAt(n - 1)){
            return 0;
        }
        return 1 + lcsuf(s1, s2, m - 1, n - 1);
    }
    public static int maxCommStr(String s1,String s2){
        int res = 0;
        int m = s1.length();
        int n = s2.length();
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                res = Math.max(res, lcsuf(s1, s2, i, j));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();
        int result = maxCommStr(s1,s2);
        System.out.println("Length of Longest Common SubString is: " + result);
    }
}