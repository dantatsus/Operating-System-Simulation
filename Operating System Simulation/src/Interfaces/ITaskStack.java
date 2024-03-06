package Interfaces;

public interface ITaskStack<T> {

	// Stack working princible: LIFO
	
	// add the entry to top.
	public void push(T newEntry);
	
	// remove the entry which is at the top.
	public T pop() throws Exception;
	
	// return the element at the top.
	public T peek() throws Exception;
	
	public boolean isEmpty();
	
	public T[] toArray();
	
}
