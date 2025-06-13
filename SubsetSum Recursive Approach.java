import java.util.Scanner;
public class SubsetSum{
    public static boolean isSubsetSum(int[] arr,int n,int target){
        //Base cases
        if(target==0){
            return true;
        }
        if(n==0){
            return false;
        }
        //If the last element is greater than the target,ignore it.
        if(arr[n-1]>target){
            return isSubsetSum(arr,n-1,target);
    }
    //Check two possibilities:include or exclude the element.
    return isSubsetSum(arr,n-1,target) || isSubsetSum(arr,n-1,target-arr[n-1]);
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
    boolean result=isSubsetSum(arr,n,target);
    System.out.println("Subset with given sum exists : "+ result);
}
}