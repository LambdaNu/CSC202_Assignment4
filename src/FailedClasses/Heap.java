package FailedClasses;

import java.util.ArrayList;

import list.ADTExceptions;

public class Heap<T extends Comparable<T>> {
	ArrayList<T> arr ;
	//private int size; 
	private int lastindex;
	//private int falsemax; 
	//boolean maxInPlay;
	private static final int DEFAULTSIZE = 10;
	
	public Heap(){
		//size = 0;
		arr = new ArrayList<T>();
		maxInPlay = false;
		lastindex = 0; 
	};
	/**For if you want a heap of a specific size.
	 * 
	 * @param capacity
	 */
	public Heap(int capacity){
		//size = 0;
		arr = new ArrayList<T>();
		falsemax = Math.abs(capacity-1); 
		maxInPlay = true; 
		lastindex = 0; 
		
	};	
	
	public boolean isEmpty(){return  arr.size() == 0 ; /*size == 0; */}
	public int size(){return arr.size();}
	public String toString(){return arr.toString();}
	
	
	public void add(T x) throws ADTExceptions{
		if(maxInPlay){
			if(lastindex == falsemax){
				throw new ADTExceptions("Overflow exception: cannot add item to full list.");
			}
			lastindex++;
			arr.add(lastindex, x);
			reheap(x);
		}else{
			lastindex++;
			arr.add(x);
			//arr.add(lastindex, x);
			reheap(x);
		}
	
	}
	private void reheap(T x){
		int gap = lastindex-1;
		while ((gap > 0) && (x.compareTo(arr.get((gap - 1) / 2)) > 0)) {
		      arr.set(gap,arr.get((gap - 1) / 2)); 
		      gap = (gap - 1) / 2;                                
		    }
		    arr.set(gap, x);
	}
	
	public T remove() throws ADTExceptions{
		if(lastindex == 0 || arr.size() == 0){
			throw new ADTExceptions("Underflow exception: cannot remove on empty list.");
		}
		T grab, transfer;
		grab = arr.get(0);
		transfer = arr.remove(lastindex-1);
		lastindex--;
		if(lastindex-1 != -1){
			reheapDown(transfer);
		}
		return grab; 
	}
	
	  private void reheapDown(T element)
	  // Current root position is "empty";
	  // Inserts element into the tree and ensures shape and order properties.
	  {
	    int gap = 0;      // current index of gap
	    int newgap;       // index where gap should move to

	    newgap = lacuna(gap, element);   // find next gap
	    while (newgap != gap)
	    {
	      arr.set(gap,arr.get(newgap));  // move element up
	      gap = newgap;                            // move gap down
	      newgap = lacuna(gap, element);          // find next gap
	    }
	    arr.set(gap, element);           // fill in the final gap
	  }
	
	  
	  private int lacuna(int gap, T element){
	    int left = getleft(gap);
	    int right = getright(gap);
	    int smallest;
	    
	    if(left <= arr.size() -1 && arr.get(left).compareTo(arr.get(gap)) <0){
	    	return left; 
	    }else{
	    	smallest = gap; 
	    }
	    if (right <= arr.size()-1 && arr.get(right).compareTo(arr.get(smallest)) < 0)
			smallest = right;  // yes, so the right child is the smallest
	    if(smallest  != gap){
	    		swap(arr,gap,smallest);
	    		lacuna(arr,smallest);
	    }
	   
	  }

		 private int parent(int n){
			 if(n==0){n = -1;}
			 else{ n = ((n-1) /2);}
			 return n;
		 }
		 private int getleft(int n) {
			 return (n * 2 + 1);}
		 private int getright(int n) {
			 return (n * 2 + 2);}
		 
}
