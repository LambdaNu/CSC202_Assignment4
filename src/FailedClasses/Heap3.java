package FailedClasses;

import java.util.ArrayList;

import list.ADTExceptions;
import restaurantLookup.BSTNode;

public class Heap3<T extends Comparable<T>> {
	private int size = -1;
	BSTNode root; 
	Heap3(){
		root = null; 
	}
	
	public void add(T x){
		if(size == 0){
			root.setData(x);
		}else if(root.getleft == null){
		}
		
		size++;
	}
	public void recfind(T x, BSTNode node){
		if(node.getLeft() ==null && node.getData().compareTo(x) < 0){
			BSTNode nunode = new BSTNode(x);
			node.setLeft(nunode);
		}
	}
	
}
