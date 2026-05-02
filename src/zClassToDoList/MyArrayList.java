package zClassToDoList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList  <T> implements Iterable<T>{
	private T[] elements;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	
	
	/**
	 * instantiates an object of MyArrayList
	 */
	@SuppressWarnings("unchecked") 	//this just tells compiler not to worry bc it doesn't like the unchecked cast
	public MyArrayList() {
		elements = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	/**
	 * increases the capacity of the array for MyArrayList. It does this by 
	 * making a copy of the old array and saving it into an array that's double
	 * the size of the old array
	 */
	private void doubleCapacity() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	/**
	 * adds a new element of type T to the end of the array
	 * @param element of type T
	 * @return true
	 */
	public boolean add(T element) {
		if (size == elements.length) {doubleCapacity();}
		elements[size++] = element;
		return true;
	}
	
	/**
	 * formats and prints the elements in the array using their
	 * toString() methods
	 */
	@Override
	public String toString() {
		if (size == 0) return "[]";
		
		String myString = "[";
		
		for (int i = 0; i < size; i++) {
			myString += elements[i].toString();
			if (i <size-1) myString += ", ";
		}
		
		myString += "]";
		
		return myString;
	}
	
	/**
	 * gets the size of the current MyArrayList
	 * @return the number of elements in the current MyArrayList
	 */
	public int size() {
		return size;
	}
	
	/**
	 * checks if the MyArrayList is empty
	 * @return true if size is zero, or false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * sets an element at a particular index of the MyArrayList
	 * @param index the index for the element to be set at
	 * @param element the element to be set
	 * @return the oldValue that was removed at the index
	 */
	public T set(int index, T element) {
		checkIndex(index);
		T oldValue = elements[index];
		elements[index] = element;
		return oldValue;
	}
	
	/**
	 * gets the element at the particular index
	 * @param index the index requested
	 * @return the element at the index
	 */
	public T get(int index) {
		checkIndex(index);
		return elements[index];
	}
	
	/**
	 * a helper method used to check if the index is within the size of the MyArrayList.
	 * throws an index out of bounds exception if index is below zero or above the size
	 * @param index the index to be checked
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index" + index + ", Size " + size);
	}
	
	/**
	 * removes the first instance of an element in the MyArrayList
	 * calls remove by index after finding the index of the first instance of the element
	 * @param element to be removed
	 * @return false if the element isn't found in the MyArrayList, true otherwise
	 */
	public boolean remove(T element) {
		int index = indexOf(element);
		if (index == -1) return false;

		return remove(index);
	}
	
	/**
	 * removes an element at the particular index
	 * calls check index and will throw an index out of bounds exception if outside the array
	 * @param index of the element be removed in the MyArrayList
	 * @return true
	 */
	public boolean remove(int index) {
		checkIndex(index);
		
		//i is the index of the element to remove
		//increment the index as long as it's smaller than the size 
		//						(because the top index is one less than the size)
		//the array at the index is now equal to the value of the next index...
		for (int i = index; i<size -1; i++) {
			elements[i] = elements[i+1];
		}
		
		//until the last index becomes null;
		elements[size - 1] = null;
		size--;
		return true;
	}
	
	/**
	 * checks if a particular element is in the array
	 * @param element to be found
	 * @return false if the element does not exist in the array, true otherwise
	 */
	public boolean contains(T element) {
		if (indexOf(element) == -1) return false;
		return true;
	}
	
	/**
	 * a helper method that gets the index of a target element
	 * @param target the element to be searched for in the array
	 * @return the index of the target element, or -1 if the element isn't found in the array
	 */
	private int indexOf(T target) {
		//have to check for null bc if you use methods on null then you will get an error
		if (target == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i; //== doesn't work on all types but it works on null
			}
		} else {
			for (int i = 0; i < size; i++) {
				
				if (elements[i].equals(target)) { //because you can't use methods on null, you can't use .equals()
					return i;
				}
			}
		}
		

		
		return -1;
	}
	
	/**
	 * creates and returns a new MyIterator
	 */
	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}
	
	/**
	 * a private class used to create an iterator for the MyArrayList class
	 * implements Iterator interface
	 */
	private class MyIterator implements Iterator<T> {
		private int cursor = 0; //index of next element to return
		
		
		/**
		 * uses a cursor to check to see if it's place is less than the size of the array and 
		 * @return true if the cursor is at a placement that is less than the size of the aray, 
		 * false otherwise
		 */
		@Override
		public boolean hasNext() {
			return cursor < size;
		}
	
		/**
		 * increments the cursor by one place, if it attempts to iterate beyond the size
		 * of the array it throws a no such element exception
		 * @return the element before the cursor increments
		 */
		@Override
		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			return elements[cursor++];
		}
		
	}
	
}
