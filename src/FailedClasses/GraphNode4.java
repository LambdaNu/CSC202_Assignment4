package FailedClasses;

public class GraphNode4 implements Comparable<GraphNode4> {
	 	public Object location;
	    public Edge4[] edges;
	    public double minDistance = Double.POSITIVE_INFINITY;
	    public GraphNode4 previous;
	    public GraphNode4(Object loc) { location = loc; }
	    public String toString() { return location.toString(); }
	    public int compareTo(GraphNode4 other)
	    {
	        return Double.compare(minDistance, other.minDistance);
	    }
}
