import java.util.*;
public class MinHeapExample{
    public static void main(String[] args){
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        //Add elements
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(3);
        //Remove and print elements.
        while(!minHeap.isEmpty()){
            System.out.print(minHeap.poll()+" ");
        }
    }
}