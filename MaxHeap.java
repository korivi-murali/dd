import java.util.*;
public class MaxHeapExample{
    public static void main(String[] args){
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        //Add elements
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(3);
        //Remove and print elements.
        while(!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll()+" ");
        }
    }
}