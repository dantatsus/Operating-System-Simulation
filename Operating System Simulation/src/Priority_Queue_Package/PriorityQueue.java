package Priority_Queue_Package;

import Interfaces.IPriorityQueue;
import Sorted_List_Package.SortedList;

public class PriorityQueue<T extends Comparable<? super T>> implements IPriorityQueue<T> {
	
	private SortedList<T> list;
	
	public PriorityQueue() {list = new SortedList<T>();}
	
	public void add(T element) throws Exception {
		if(element == null) {throw new Exception("Null element : PQ add method");}
		list.add(element);
	}
	
	public T remove() {
		T result = list.getEntry(1); // First element
		if (list.remove(result)) {return result;}
		else {return null;}
	}
	
	public T peek() {return list.peek();}
	
	public boolean isEmpty() {return list.isEmpty();}
	
	public int getSize() {return list.getSize();}
	
	public void clear() {list.clear();}
	
	public T[] toArray() {return list.toArray();}
}
