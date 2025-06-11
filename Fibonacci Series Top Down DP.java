import java.util.HashMap;
import java.util.Scanner;
public class Main{
    private HashMap<Integer,Integer>memo=new HashMap<>();
    public int fibMemo(int n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n<=1){
            return n;
        }
        int result=fibMemo(n-1)+fibMemo(n-2);
        memo.put(n,result);
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a non-negative integer n: ");
        int n=scanner.nextInt();
        if(n<0){
            System.out.println("Invalid input! Please enter a non-negative integer.");
        }
        else{
            Main fibonacci=new Main();
            int result=fibonacci.fibMemo(n);
            System.out.println("Fibonacci of " + n + " is " + result);
        }
        scanner.close();
    }
}
