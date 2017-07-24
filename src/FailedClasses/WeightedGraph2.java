package FailedClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph2<T> {
	List<GraphNode2> nodes; 
	public WeightedGraph2(){};
	
	public boolean isEmpty(){
		return(nodes.size() == 0);
	}
	public void addVertex(T vertex){
		nodes.add( new GraphNode2(vertex));
	}
	public GraphNode2 getVertex(int a){
		return nodes.get(a); 
	}
	/*public void removeVertex(T vertex){
		if(nodes.contains(vertex)){
			
		}
	} */

	public void addEdge(T startVertex, T endVertex, double weight){
		GraphNode2 startNode = new GraphNode2(startVertex);
		GraphNode2 endNode = new GraphNode2(endVertex);
		startNode.addEdge2(weight,endNode);
	}
	
	//Dijkstra all the freakin' way right now...
	 public static void computePaths(GraphNode2 source)
	    {
	        source.minDistance = 0.;
	        PriorityQueue<GraphNode2> vertexQueue = new PriorityQueue<GraphNode2>();
	    vertexQueue.add(source);

	    while (!vertexQueue.isEmpty()) {
	        GraphNode2 u = vertexQueue.poll();

	            // Visit each edge exiting u
	            for (Edge2 e : u.getEdge2s())
	            {
	                GraphNode2 v = e.getDestination();
	                double weight = e.getWeight();
	                double distanceThroughU = u.minDistance + weight;
	        if (distanceThroughU < v.minDistance) {
	            vertexQueue.remove(v);

	            v.minDistance = distanceThroughU ;
	            v.setPreviousNode(u);
	            vertexQueue.add(v);
	        }
	            }
	        }
	    }

	    public static List<GraphNode2> getShortestPathTo(GraphNode2 target)
	    {
	        List<GraphNode2> path = new ArrayList<GraphNode2>();
	        for (GraphNode2 vertex = target; vertex != null; vertex = vertex.getPreviousNode()){
	            path.add(vertex);
	        }


	        Collections.reverse(path);
	        return path;
	    }
	
	
	
	
}
