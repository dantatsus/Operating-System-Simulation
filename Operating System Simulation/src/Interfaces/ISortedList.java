package Interfaces;

public interface ISortedList<T extends Comparable<? super T>> {
	
	// This is a sorted list which implements linked list.
	
	// Add and remove, with getPosition update.
	public void add(T newEntry);
	public boolean remove(T anEntry);
	
	// Find the position for entry according to its priority.
	public int getPosition(T anEntry);
	
	// Same as Linked List
	public boolean isEmpty();
	public void clear();
	public boolean contains(T anEntry);
	public T getEntry(int position);
	public int getSize();
	public T peek();
	public T[] toArray();
	
}
