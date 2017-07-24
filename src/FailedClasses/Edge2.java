package FailedClasses;

 
public class Edge2{
	//Variables
	private double weight; 
	private GraphNode2 destination = new GraphNode2(); 
	private GraphNode2 source = new GraphNode2(); 
	//private String id; 
	//Constructor
	public Edge2(){};
	public Edge2(double weight, GraphNode2 destination){
		this.weight = weight; 
		this.destination = destination; 
	}
	/*public Edge(double weight, GraphNode2 destination, Graph)//, String id){ //oneway street?
		this.weight = weight; 
		this.destination = destination; 
		//this.id = id; 
	} */
	public Edge2(double weight, GraphNode2 destination, GraphNode2 source){//, String id){
		this.weight = weight; 
		this.destination = destination; 
		this.source = source; 
		//this.id = id; 
	}
	//SetGet
	public double getWeight() {return weight;}
	public void setWeight(double weight) {this.weight = weight;}
	public GraphNode2 getDestination() {return destination;}
	public void setDestination(GraphNode2 destination) {this.destination = destination;}
	public GraphNode2 getSource() {return source;}
	public void setSource(GraphNode2 source) {this.source = source;}
	/*public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	} */
	
	
	
	public String toString(){
		String returnval = "Distance: " + getWeight() + ", Destination: " + getDestination().getData().toString() + ", Source: " + getSource().getData().toString() + "]";//+ ", ID: " + getId() + "]" ;// + getDestination().toString();
		return returnval;
	}
}
