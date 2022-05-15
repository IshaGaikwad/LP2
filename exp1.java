import java.io.*;
import java.text.BreakIterator;
import java.util.*;


class SGraph{
    private int verticesCount;                               
    private ArrayList<Integer> adjacencyList[];              
    int BFSFlag =0;
    int DFSFlag =0;
    SGraph(int v){
        verticesCount = v;
        adjacencyList = new ArrayList[v];
        
        for (int i=0; i<v; i++){
            adjacencyList[i] = new ArrayList<>();                   
        }
    }

    void addEdge(int vertex1,int vertex2){
        adjacencyList[vertex1].add(vertex2);   
        adjacencyList[vertex2].add(vertex1);                        
    }
 
    void DFSUtil(int vertex, boolean visited[], int searchVertex){
        if(DFSFlag == 1)
        {
        	return;
        }
    	visited[vertex] = true;                                      
        System.out.print(vertex + " ");
        if(searchVertex == vertex){
            DFSFlag = 1;     
           
        }
     
        for (int u: adjacencyList[vertex]){  
            if (!visited[u]){                                       
                DFSUtil(u, visited, searchVertex);
            }
        }  
    }
    void DFS(int v,int searchVertex){
    	DFSFlag = 0;
    	boolean visited[] = new boolean[verticesCount];             
        DFSUtil(v, visited,searchVertex);
        if(DFSFlag==1){
            System.out.println("\nElement Found in Graph");
        }else{
            System.out.println("\nElement Not Found in Graph");
        }
    }

    void recursiveBFS(Queue<Integer> q, boolean[] visited, int searchVertex){
        if (q.isEmpty()){
            return;
        }
        if(BFSFlag == 1 )
        {
        	return;
        }
        int v = q.poll();                       
        System.out.print(v + " ");
        visited[v] = true;
        if(searchVertex == v||BFSFlag == 1 ){
            BFSFlag = 1;
            
        } 
        for (int u: adjacencyList[v]){         
            if (!visited[u]){
                visited[u] = true;              
                q.add(u);     
            }
        }

        recursiveBFS(q, visited,searchVertex);
    }


    void BFS(int v,int searchVertex){
    	BFSFlag = 0;
    	boolean[] visited = new boolean[verticesCount];
		Queue<Integer> q = new ArrayDeque<>();                  
        q.add(v);    
        recursiveBFS(q, visited,searchVertex);
        if(BFSFlag==1){
            System.out.println("\nElement Found in Graph");
        }else{
            System.out.println("\nElement Not Found in Graph");
        }
    }
}

public class exp1{
    public static void main(String args[]){
        

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Vertices : ");
        int vertexCount = sc.nextInt();
        SGraph graph = new SGraph(vertexCount);

        System.out.print("Enter Number of Edges : ");
        int edgeCount = sc.nextInt();
        for(int i=0;i<edgeCount;i++){
            int v1,v2;
            System.out.println("Add Edge ");
            System.out.print("From Vertex  : ");
            v1=sc.nextInt();
            System.out.print("To Vertex  : ");
            v2=sc.nextInt();
            graph.addEdge(v1,v2);
        }

        boolean run = true;
        while(run){
            System.out.print("\nEnter Search Element : ");
            int searchVertex = sc.nextInt();
            System.out.print("Breadth First Search : "); 
            graph.BFS(0,searchVertex);
            System.out.print("\n\nDepth First Search : "); 
            graph.DFS(0,searchVertex);

            System.out.print("\nWant to Seach other element [Y/N]: ");
            if(!(sc.next().equalsIgnoreCase("y"))){
                run = false;
            }
        }

    }
}
/*
                 0
                /  \
               1    2
              / \  / \
             3  4  5  6
            / \     \
           7   8     9
          /
        10
 
    */


    