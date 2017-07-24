package FailedClasses;

import java.util.ArrayList;

import list.ADTExceptions;

public class Heap2<T extends Comparable<T>> { //it's a maxheap in how it's ordered...but it removes from the back. 
	ArrayList<T> arr ;
	//private int size; 
	private int lastindex;
	private int falsemax; 
	boolean maxInPlay;
	//private static final int DEFAULTSIZE = 10;
	
	public Heap2(){
		//size = 0;
		arr = new ArrayList<T>();
		maxInPlay = false;
		lastindex = 0; 
	};
	/**For if you want a heap of a specific size.
	 * 
	 * @param capacity
	 */
	public Heap2(int capacity){
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
		if(lastindex == 0){
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
	
	  private void reheapDown(T x)
	  // Current root position is "empty";
	  // Inserts x into the tree and ensures shape and order properties.
	  {
	    int gap = 0;      // current index of gap
	    int newgap;       // index where gap should move to

	    newgap = lacuna(gap, x);   // find next gap
	    while (newgap != gap)
	    {
	      arr.set(gap,arr.get(newgap));  // move x up
	      gap = newgap;                            // move gap down
	      newgap = lacuna(gap, x);          // find next gap
	    }
	    arr.set(gap, x);           // fill in the final gap
	  }
	
	  
	  private int lacuna(int gap, T x){
	    int left = getleft(gap);
	    int right = getright(gap);

	    if (left > lastindex){
	      return gap;         
	  }else{
	    if (left == lastindex){
	      if (x.compareTo(arr.get(left)) < 0){             
	        return left;
	      }else{
	        return gap;}
	    }else{
	    if (arr.get(left).compareTo(arr.get(right)) < 0)
	      if (arr.get(right).compareTo(x) <= 0){
	        return gap;
	      }else{
	        return right;}
	    else{
	    if (arr.get(left).compareTo(x) <= 0){
	      return gap;
	    }else{
	      return left;}}}}
	  }

		 private int getleft(int n) {
			 return (n * 2 + 1);}
		 private int getright(int n) {
			 return (n * 2 + 2);}
		 /*
		 private T getLesser(int n){
			 if(left(n) > arr.size() - 1){
				 return -1;
			 }
			 if(right(n) > arr.size() -1){
				 return left(n);
			 }
		 }  
	 	*/
	    /*public boolean isHeap() {
	        for (int i = 1; i < arr.size(); ++i) {
	            if (parent(i) >= 0) {
	                if (arr.get(i).compareTo(arr.get(i)) > 0) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }  */
}
