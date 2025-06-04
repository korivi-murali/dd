class Main {
    static int SumOfNaturalNumbers(int n){
        if(n==1){
            return 1;
        }
        else{
            return n+SumOfNaturalNumbers(n-1);
        }
    }
    public static void main(String[] args) {
        int number=10;
        int result=SumOfNaturalNumbers(number);
        System.out.println("Sum of first "+number+" natural numbers is "+result);
  }
}