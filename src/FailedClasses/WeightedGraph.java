package FailedClasses;

import java.util.List;

import restaurantLookup.GraphNode;

public class WeightedGraph<T> {
	/*public static final int NULL_EDGE = 0;
	private static final int DEFCAP = 50;
	private int numVertices, maxVertices;
	private T[]vertices; 
	private int[][]edges;
	private boolean[] marks; 
	
	@SuppressWarnings("unchecked")
	public WeightedGraph(){
        numVertices = 0;
        maxVertices = DEFCAP;
        vertices = (T[ ]) new Object[DEFCAP];
        marks = new boolean[DEFCAP];
        edges = new int[DEFCAP][DEFCAP];
    }
	@SuppressWarnings("unchecked")
	public WeightedGraph(int maxvertices){
        numVertices = 0;
        maxVertices = maxvertices;
        vertices = (T[ ]) new Object[maxvertices];
        marks = new boolean[maxvertices];
        edges = new int[maxvertices][maxvertices];
    }
	public void addVertex(T vertex)
    {
        vertices[numVertices] = vertex;
        for (int index = 0; index < numVertices; index++)
        {
            edges[numVertices][index] = NULL_EDGE;
            edges[index][numVertices] = NULL_EDGE;
        }
        numVertices++;
        //setVertex(vertex);
    }
	
	private int indexIs(T vertex){
		int index = 0; 
		
	} */
	List<GraphNode> nodes; 
	
	public boolean isEmpty(){
		return(nodes.size() == 0);
	}
	public void addVertex(T vertex){
		GraphNode tr = new GraphNode(vertex);
		nodes.add(tr);
	}
	public T getVertex(int index){
		 T x  = (T) nodes.get(index).getData();
		return x; 
	}
	
	public void addEdge(T startVertex, T endVertex, double weight){
		GraphNode startNode = new GraphNode(startVertex);
		GraphNode endNode = new GraphNode(endVertex);
		startNode.addEdge(weight,endNode);
	}
	
	
	
	
	
	
	
}
