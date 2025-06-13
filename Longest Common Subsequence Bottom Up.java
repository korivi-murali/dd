import java.util.Scanner;
import java.util.Arrays;
public class LCS{
    public static int lcsMemo(String x,String y){
        int m=x.length(),n=y.length();
        int[][] memo=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1=scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2=scanner.nextLine();
        int result=lcs_dp(s1,s2);
        System.out.println("Length of Longest Common Subsequence is: " + result);
        scanner.close();
    }
}
