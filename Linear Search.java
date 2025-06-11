import java.util.Scanner;
public class Main{
    // Linear search method
    public static int linearSearch(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i; // return the index where target is found
            }
        }
        return-1; // target not found
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n=scanner.nextInt();

        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.print("Enter the target value to search: ");
        int target=scanner.nextInt();
        int result=linearSearch(arr,target);
        if(result==-1){
            System.out.println("Target not found.");
        }
        else{
            System.out.println("Target found at index: " + result);
        }
        scanner.close();
    }
}
