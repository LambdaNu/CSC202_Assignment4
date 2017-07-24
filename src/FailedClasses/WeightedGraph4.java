package FailedClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph4 {
	public static void computePaths(GraphNode4 source)
    {
        source.minDistance = 0.;
        PriorityQueue<GraphNode4> vertexQueue = new PriorityQueue<GraphNode4>();
    vertexQueue.add(source);

    while (!vertexQueue.isEmpty()) {
        GraphNode4 u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge4 e : u.edges)
            {
                GraphNode4 v = e.location;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
        if (distanceThroughU < v.minDistance) {
            vertexQueue.remove(v);

            v.minDistance = distanceThroughU ;
            v.previous = u;
            vertexQueue.add(v);
        }
            }
        }
    }

    public static List<GraphNode4> getShortestPathTo(GraphNode4 target)
    {
        List<GraphNode4> path = new ArrayList<GraphNode4>();
        for (GraphNode4 vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

}
