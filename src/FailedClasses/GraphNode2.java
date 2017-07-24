package FailedClasses;

import java.util.ArrayList;
import java.util.List;

public class GraphNode2 implements Comparable<GraphNode2>{
	private Object data; 
	private ArrayList<Edge2> edges  = new ArrayList<Edge2>(); 
	public double minDistance = Double.MAX_VALUE;
	private GraphNode2 previousNode;
	
	
	public GraphNode2(){}
	public GraphNode2(Object data){
		this.data = data; 

	}
	public Object getData() {return data;}
	public void setData(Object data) {this.data = data;}
	public GraphNode2 getPreviousNode() {
		return previousNode;
	}
	public void setPreviousNode(GraphNode2 previousNode) {
		this.previousNode = previousNode;
	}

	public void addEdge2(double weight,  GraphNode2 destination){
		edges.add(new Edge2(weight, destination,this));
	}
	public void addEdge2(double weight,  GraphNode2 destination, int id){
		edges.add(new Edge2(weight, destination,this));
	}
	public void addEdge2(double weight, Object destination){
		GraphNode2 newNode = new GraphNode2(destination);
		edges.add(new Edge2(weight, newNode,this));
	}
	
	public void addEdge2(double weight, Object destination,int id){
		GraphNode2 newNode = new GraphNode2(destination);
		edges.add(new Edge2(weight, newNode,this));
		//edges.add(new Edge2(weight, newNode,this,Integer.toString(id)));
	}
	
	public ArrayList<Edge2> getEdge2s(){
		return edges; 
	}
	
		
	public String toString(){
		String returnval = "" + this.getData();
		return returnval; 	}
	
	public String edgesObjectoString(){
		String header = this.getData().toString() + ": [Destination, Distance] \n ----------------- \n";
		String returnval = "";
		if(edges.size() == 0){
			//String header = this.getData().toString() + ": \t Distance  \t Destination \n ----------------------------------- \n";
			return header; 
			//return returnval; 
		}else{
			
	
		for(int i = 0; i < edges.size(); i++){
			returnval = returnval  + edges.get(i).toString() + "\n";
		}

		returnval = header + returnval; 
		return returnval; 	}
	}
	@Override
	public int compareTo(GraphNode2 o) {
		
		  return Double.compare(minDistance, o.minDistance);
	}
	
}

