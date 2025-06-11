import java.util.Scanner;
public class Main{
    public static void printPairs(int[] arr){
        for(int i:arr){
            for(int j:arr){
                System.out.println(i + " " + j);
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n=scanner.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter " + n + " elements:");
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        printPairs(arr);
        scanner.close();
    }
}
