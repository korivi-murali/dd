import java.util.Scanner;
import java.util.Arrays;
public class SubsetSumMemo{
    public static boolean isSubsetSumMemo(int[] arr,int n,int target,int[][] dp){
        //Base cases
        if(target==0){
            return true;
        }
        if(n==0){
            return false;
        }
        //If value is already computed
        if(dp[n][target]!=-1){
            return dp[n][target]==1;
        }
        //If the last element is greater than the target,ignore it.
        if(arr[n-1]>target){
            dp[n][target]=isSubsetSumMemo(arr,n-1,target,dp)?1:0;
        }
        else{
            //Include or exclude the current element.
            boolean include=isSubsetSumMemo(arr,n-1,target-arr[n-1],dp);
            boolean exclude=isSubsetSumMemo(arr,n-1,target,dp);
            dp[n][target]=(include || exclude)?1:0;
        }
        return dp[n][target]==1;
    }
    public static void main(String[] args){
     Scanner scanner=new Scanner(System.in);
        // Get array size
        System.out.print("Enter the number of elements in the array: ");
        int n=scanner.nextInt();
        int[] arr=new int[n];
        // Get array elements
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        // Get target sum
        System.out.print("Enter the target sum: ");
        int target=scanner.nextInt();
        //Initialize dp table with -1(means not compute)
        int[][] dp=new int[n+1][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        boolean result=isSubsetSumMemo(arr,n,target,dp);
        System.out.println("Subset with given sum exists(memo) : "+ result);
    }
}