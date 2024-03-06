package Interfaces;

public interface IPriorityQueue<T extends Comparable<? super T>> {

	// This is an Priority Queue which implements sorted list.
	
	public void add(T element) throws Exception;
	
	public T remove();
	
	// return the first element of the queue.
	public T peek();
	
	public boolean isEmpty();
	
	public int getSize();
	
	public void clear();
	
	public T[] toArray();
	
	
}
