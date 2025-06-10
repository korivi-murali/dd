import java.io.*;
class Main{
    //Merges two subarrays of arr[].
    //First subarray is arr[I...m]
    //Second subarray is arr[m+1...r]
    static void merge(int arr[], int I, int m, int r){
        //Find sizes of two subarrays to be merged
        int n1=m-I+1;
        int n2=r-m;
        //create temp arrays
        int L[]=new int[n1];
        int R[]=new int[n2];
        //copy data to temp arrays
        for(int i=0; i<n1;++i)
           L[i]=arr[I+i];
        for(int j=0;j<n2;++j)
           R[j]=arr[m+1+j];
           //Merge the temp arrays
           //Initial index of first and second subarrays
           int i=0,j=0;
           //Initial index of merged subarray array
           int k=I;
           while(i<n1 && j<n2){
               if(L[i]<=R[j]){
                   arr[k]=L[i];
                   i++;
               }
               else{
                   arr[k]=R[j];
                   j++;
               }
               k++;
           }
           //copy remaining elements of R[] if any
           while(i<n1){
               arr[k]=L[i];
               i++;
               k++;
           }
           //copy remaining elements of R[] if any
           while(j<n2){
               arr[k]=R[j];
               j++;
               k++;
           }
    }
    //Main function that sorts arr[I...r] using Merge()
    static void sort(int arr[],int I,int r){
        if(I<r){
            //Find the middle point
            int m=I+(r-I)/2;
            //Sort first and second halves
            sort(arr,I,m);
            sort(arr,m+1,r);
            //Merge the sorted halves
            merge(arr,I,m,r);
        }
    }
    //A utility function to print array of size n.
    static void printArray(int arr[]){
        int n=arr.length;
        for (int i=0;i<n;++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //Driver code
    public static void main(String[] args){
            int arr[]={12, 11, 13, 5, 6, 7};
            System.out.print("Given array is :");
            printArray(arr);
            sort(arr,0,arr.length-1);
            System.out.print("\nSorted array is :");
            printArray(arr);
        }
}