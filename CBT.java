/* Complete Binary Tree Starter
 * DSA 
 * Matthew Twigg
 * Ms. Tompsett
 * December 2021
 * 
 */

import java.util.*;

public class CBT{
    private ArrayList tree;

    public CBT(){
	tree = new ArrayList();
    }

    //traversals
    public void inOrder(int root){ //Accesses tree from left then to root and then right
    	if (root >= tree.size()) {	//base case
    		return;
    	}
    	
    	int leftNode = root + root + 1;
    	int rightNode = root + root + 2;
    	
    	if(leftNode < tree.size()) { //first accessing left node
    		inOrder(leftNode);
    	}
    	
    	System.out.println(tree.get(root));
    	
    	if(rightNode < tree.size()) { //accessing right node
    		inOrder(rightNode);
    	}

    }
    
    public void preOrder(int root) { //Accesses tree from root then left and then right
    	if (root >= tree.size()) { //Base case
    		return;
    	}
    	int leftNode = root + root + 1;
    	int rightNode = root + root + 2;
    	
    	System.out.println(tree.get(root));
    	
    	if (leftNode < tree.size()) { //accessing left node
    		preOrder(leftNode);
    	}
    	if (rightNode < tree.size()) {// accessing right node
    		preOrder(rightNode);
    	}
    }
    
    public void postOrder(int root) { // accesses tree from left node then right then root
    	if (root >= tree.size()) { // base case
    		return;
    	}
    	int leftNode = root + root + 1;
    	int rightNode = root + root + 2;
    	
    	
    	if (leftNode < tree.size()) { //accesess left node
    		postOrder(leftNode);
    	}
    	if (rightNode < tree.size()) {// accesses right node
    		postOrder(rightNode);
    	}
    	System.out.println(tree.get(root));
    }
    
    public void breadthFirst() {// accsses each level of the tree at once
    	for(int i = 0; i < tree.size(); i++) { // loops through entire arraylist 
    		System.out.println(tree.get(i));
    	}
    }

    //accessors
    public boolean contains(Object o) { // loops through arraylist and checks if input is there
    	for(int i = 0; i < tree.size(); i++) {
    		if(tree.get(i) == o) {
    			return true;
    		}
    	}
    	return false;
    }

    //mutators
    public boolean add(Object o){ // adds input to the end the list/ leaf node
    	tree.add(o);
    	return contains(o);
    }
    public boolean remove(Object o){ //  checks if input is contained, then finds input and replaces it with element at the leaf node, oringal leaf node index is deleted.
    	if (tree.contains(o) == true) {
    		for (int i = 0; i < tree.size(); i++){	
        		if (tree.get(i) == o) {	
        			tree.set(i, tree.get(tree.size() - 1));
        			tree.remove(tree.size() - 1);
        			return true;
        		}
        	}
    	}
		return false;
    }

    public static void main(String[] args){
    	CBT myTree = new CBT(); 
    	myTree.add(1);
    	myTree.add(2);
    	myTree.add(3);
    	myTree.add(4);
    	myTree.add(5);
    	myTree.add(6);
    	myTree.add(7);
    	myTree.add(8);
    	myTree.add(9);
    	myTree.add(10);
    	System.out.println("------------------IN ORDER:");
    	myTree.inOrder(0);
    	System.out.println("------------------PRE ORDER:");
    	myTree.preOrder(0);
    	System.out.println("------------------POST ORDER:");
    	myTree.postOrder(0);
    	System.out.println("------------------BREADTH FIRST ORDER:");
    	myTree.breadthFirst();
    	System.out.println("------------------CONTAINS:");
    	System.out.println(myTree.contains(2));
    	System.out.println("------------------ADD:");
    	myTree.add(11);
    	myTree.breadthFirst();
    	System.out.println("------------------Remove:");
    	myTree.remove(11);
    	myTree.breadthFirst();
    	
    	
    	
    	
    	
    	
    }
}
