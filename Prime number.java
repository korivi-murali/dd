import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n value");
        int n=sc.nextInt();
        int i,count=0;
        for(i=1;i<=n;i++){
            if(n%i==0){
                count+=1;
            }
        }
        if(count==2){
            System.out.println(n +" is a Prime number");
        }
        else{
            System.out.println(n +" is not a Prime number");
        }
    }
}