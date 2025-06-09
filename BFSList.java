import java.util.*;
public class BFSList{
    public static void bfs(List<List<Integer>>graph,int start){
        int n=graph.size();
        boolean[] visited=new boolean[n];
        Queue<Integer>queue=new LinkedList<>();
        visited[start]=true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int current=queue.poll();
            System.out.print(current+" ");
            for(int neighbor:graph.get(current)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.offer(neighbor);
                }
            }
        }
    }
    public static void main(String[] args){
        //Create a graph with 4 nodes.
        int n=4;
        List<List<Integer>>adjList=new ArrayList<>();
        //Initialize adjacency lists
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        //Add edges(Undirected graph)
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(0);
        adjList.get(1).add(3);
        adjList.get(2).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(1);
        adjList.get(3).add(2);
        System.out.println("BFS starting from node 0:");
        bfs(adjList,0);
    }
}