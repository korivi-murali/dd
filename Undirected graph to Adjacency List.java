import java.util.ArrayList;
import java.util.List;
public class Main{
    //Method to add an edge between two vertices.
    public static void addEdge(List<List<Integer>>adj,int i,int j){
        adj.get(i).add(j);
        adj.get(j).add(i);//Undirected
    }
    //Method to display the adjacency list
    public static void displayAdjList(List<List<Integer>>adj){
        for(int i=0;i<adj.size();i++){
            System.out.print(i+":");//Print the vertex
            for(int j:adj.get(i)){
                System.out.print(j+" ");//Print its adjacent
            }
            System.out.println();
        }
    }
    //Main Method
    public static void main(String[] args){
        //Create a graph with 4 vertices and no edges.
        int v=4;
        List<List<Integer>>adj=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        //Now add edges one by one
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        System.out.println("Adjacency List Representation:");
        displayAdjList(adj);
    }
}