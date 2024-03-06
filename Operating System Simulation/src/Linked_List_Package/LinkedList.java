package Linked_List_Package;

import Interfaces.ILinkedList;
import Task_Package.Task;

public class LinkedList<T> implements ILinkedList<T> {
	
	private Node firstNode;
	private int numberOfEntries;
	private Node lastNode;
	
	public LinkedList() {initializeDataFields();}
	
	private void initializeDataFields(){
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}
	
	public void add(T newEntry)	{
		
		Node newNode = new Node(newEntry);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
		numberOfEntries++;
	}
	
	public void add(int newPosition, T newEntry){
		
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)){
			Node newNode = new Node(newEntry);
			if (isEmpty()){
				firstNode = newNode;
				lastNode = newNode;
				}
	 else if (newPosition == 1){
		 newNode.setNextNode(firstNode);
		 firstNode = newNode;
	 		}
	 else if (newPosition == numberOfEntries + 1){
		 lastNode.setNextNode(newNode);
		 lastNode = newNode;
	 		}
	 else{
		 Node nodeBefore = getNodeAt(newPosition - 1);
	 	Node nodeAfter = nodeBefore.getNextNode();
	 	newNode.setNextNode(nodeAfter);
	 	nodeBefore.setNextNode(newNode);
	 		} // end if
			numberOfEntries++;
		}
	 else
		 throw new IndexOutOfBoundsException("Illegal position given to add operation.");
	}
	
	public T remove(int givenPosition){
		
		T result = null; // Return value
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
			assert !isEmpty();
			if (givenPosition == 1) // Case 1: Remove first entry
			{
				result = firstNode.getData(); // Save entry to be removed
				firstNode = firstNode.getNextNode();
				if (numberOfEntries == 1)
					lastNode = null; // Solitary entry was removed
			}
			else // Case 2: Not first entry
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
				result = nodeToRemove.getData(); // Save entry to be removed
				if (givenPosition == numberOfEntries)
					lastNode = nodeBefore; // Last node was removed
			} // end if
			numberOfEntries--;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
		return result; 
	}
	
	public T[] toArray(){
		
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Task[numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)){
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		} 
		return result;
	}
	
	public T replace(int givenPosition, T newEntry){
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
			assert !isEmpty();
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	} 
	
	public T getEntry(int givenPosition){
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	}
	
	public boolean contains(T anEntry){
		
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null)){
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		return found;
	}
	
	public boolean isEmpty() {
		
		boolean result;
		if (numberOfEntries == 0) {
			assert firstNode == null;
			result = true;
		}
		else {
			assert firstNode != null;
			result = false;
		}
		return result;
	}
	
	// Note: This method is for Priority Queue peek method.
	public T peek() {
		return firstNode.getData();
	}
	
	public int getLength() {return numberOfEntries;}
	
	public void clear() {initializeDataFields();}
	
	private Node getNodeAt(int position) {
		
		assert (firstNode != null) && (1 <= position) && (position <= numberOfEntries);
		Node currentNode = firstNode;
		
		for (int counter = 1; counter < position; counter++)
			currentNode = currentNode.getNextNode();
		
		assert currentNode != null;
		
		return currentNode;
	}
	
	private class Node {
		
		private T data;
		private Node next;
		
		private Node(T dataPortion) {this(dataPortion, null);}
		
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		
		private T getData() {return data;}
		
		private void setData(T newData) {data = newData;}
		
		private Node getNextNode() {return next;}
		
		private void setNextNode(Node nextNode) {next = nextNode;}
		
	}
	
}
