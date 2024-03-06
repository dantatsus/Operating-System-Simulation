package ADT_Stack_Package;

import java.util.Arrays;

import Interfaces.ITaskStack;
import Task_Package.Task;

public class TaskStack<T> implements ITaskStack<T>{
	
	private T[] stack; // Array of stack entries
	private int topIndex; // Index of top entry
	private boolean initialized = false;

	
	public TaskStack(int capacity) {
		
		@SuppressWarnings("unchecked") 
		T[] tempStack = (T[])new Task[capacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
		
	}
	
	public void push(T newEntry) {
		
		checkInitialization();
		ensureCapacity();
		if (newEntry == null) {System.out.println("null push");}
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	
	public T pop() throws Exception {
		
		checkInitialization();
		
		if (isEmpty())
			throw new Exception("Stack is empty.");
		else
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		} // end if
	}
	
	public T peek() throws Exception {
		
		checkInitialization();
		if (isEmpty())
			throw new Exception("Stack is empty.");
		else
			return stack[topIndex];
	}
	
	public boolean isEmpty() {
		return topIndex < 0;
	}
	
	private void ensureCapacity() {
			
		if (topIndex == stack.length - 1) {
			int newLength = 2 * stack.length;
			stack = Arrays.copyOf(stack, newLength);
		} // end if
	}
	
	private void checkInitialization(){
		if (!initialized)
			throw new SecurityException("ArrayBag object is not initialized properly.");
	}
	
	public T[] toArray() {
		
		@SuppressWarnings("unchecked") 
		T[] result = (T[])new Task[topIndex+1];
		for(int index = 0; index < topIndex+1; index++) {result[index] = stack[index];}
		return result;
	}
}
