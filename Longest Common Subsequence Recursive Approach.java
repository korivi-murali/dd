import java.util.Scanner;
import java.util.Arrays;
public class LCS{
    public static int lcs(char[] x,char[] y,int m,int n){
        if(m==0 || n==0){
            return 0;
        }
        if(x[m-1]==y[n-1]){
            return 1+lcs(x,y,m-1,n-1);
        }
        else{
            return Math.max(lcs(x,y,m,n-1),lcs(x,y,m-1,n));
        }
    }
     public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1=scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2= scanner.nextLine();
        int result=lcs(s1.toCharArray(),s2.toCharArray(),s1.length(),s2.length());
        System.out.println("Length of Longest Common Subsequence: " + result);
        scanner.close();
    }
}