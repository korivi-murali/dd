class Node {
    int data;
    Node next;
    Node (int data){
        this.data=data;
        this.next=null;
    }
}
//Queue class using linked list
class Queue {
    private Node front,rear;
    public Queue(){
        this.front=this.rear=null;
    }
    //Enqueue operation
    public void enqueue(int data){
        Node newNode=new Node(data);
        if(rear==null){
            front=rear=newNode;
            return;
        }
        rear.next=newNode;
        rear=newNode;
    }
    //Dequeue operation
    public int dequeue(){
        if(front==null){
            System.out.println("Queue Underflow! cannot dequeue from an empty Queue.");
            return -1;
        }
        int dequeuedData=front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        return dequeuedData;
    }
    //Peek at the front element
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return-1;
        }
        return front.data;
    }
    //Check if queue is empty
    public boolean isEmpty(){
        return front==null;
    }
    //Display the queue
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return;
        }
        Node temp=front;
        while(temp != null){
            System.out.println(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("None");
    }
}
//Usage
public class Main{
    public static void main(String[] args){
        Queue queue=new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        System.out.println("Dequeued:"+queue.dequeue());
        System.out.println("Front element:"+queue.peek());
        queue.display();
    }
}