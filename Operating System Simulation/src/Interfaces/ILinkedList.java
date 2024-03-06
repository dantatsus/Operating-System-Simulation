package Interfaces;

public interface ILinkedList<T> {
	
	// add methods
	public void add(T newEntry);
	public void add(int newPosition, T newEntry);
	
	// remove method
	public T remove(int givenPosition);
	
	public T[] toArray();
	
	// Change the entry's place with new position.
	public T replace(int givenPosition, T newEntry);
	
	// return the entry in the given position.
	public T getEntry(int givenPosition);
	
	// Check the entry and return true if it is in list. Else, return false.
	public boolean contains(T anEntry);
	
	// Check the list and return true if it is empty.
	public boolean isEmpty();
	
	// For Priority Q
	public T peek();
	
	// return size
	public int getLength();
	
	public void clear();
	
	// private class Node
}
