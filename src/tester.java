import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import FailedClasses.Heap2;
import restaurantLookup.GeoLocation;
import restaurantLookup.GraphNode;
import restaurantLookup.Restaurant;
import restaurantLookup.WeightedGraph_Implementation;

public class tester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*Heap<Integer> h = new Heap<Integer>(); 
		h.add(10);
		h.add(6);
		h.add(25);
		h.add(34);
		h.add(22);
		h.add(5);
		h.add(12);
		System.out.println(h.remove());
		System.out.println(h.remove());
		System.out.println(h.remove());
		System.out.println(h.toString()); */

		/*
		String mypath = "src/restaurantLookup/relfiles/RESTAURANT_LIST.xls";
		UtilityMethods ul = new UtilityMethods(); 
		Restaurant[] restarr = ul.excelDataToRestaurant(ul.ReadExcel(mypath));
		ArrayList<GraphNode> graphArr = new ArrayList(); 

		
		for(int i = 0; i < restarr.length; i++ ){
			GraphNode<Restaurant> g = new GraphNode(restarr[i]);
			graphArr.add(g);

		}
		
		for(int i = 0; i < graphArr.size(); i++){
			//set number of connections (min 1 max entire graph)
			int connections  = 1 + (int)(Math.random()*graphArr.size());
			while(connections!= 0){
				int connector = ((int)(Math.random()*graphArr.size()));
				if(i != connector && !graphArr.get(i).getEdges().contains(graphArr.get(connector))){ //so the connection cannot be to itself
					
					double weigh = restarr[i].getLocation().getHaversineDistance(restarr[connector].getLocation());
					graphArr.get(i).addEdge(weigh, graphArr.get(connector),connector);
					connections--;
				}

				
			}
			
		}
		
		System.out.print(graphArr.get(20).edgesToString()); */
		
		/*
		GraphNode<String> graph = new GraphNode();
		GraphNode<String> LosAngeles = new GraphNode("Los Angeles");
		graph.setData("Chicago");
		graph.addEdge(100.10, "New York");
		graph.addEdge(3000, "Tokyo");
		graph.addEdge(235.6, LosAngeles);
		
	*/
			Restaurant Mylocation = new Restaurant(); 
			GeoLocation myloc = new GeoLocation(33.1,-77);
			Mylocation.setLocation(myloc);
			Mylocation.setRestaurantName("My Location");

		GraphNode<Restaurant> gn = new GraphNode<Restaurant>(Mylocation);
		
		WeightedGraph_Implementation<Restaurant> wgI = new WeightedGraph_Implementation<Restaurant>(gn);	
		wgI.findMinDistance(gn);
		LinkedList<GraphNode> path = wgI.getPath(10);
		System.out.println(path.size());
		}
	}


