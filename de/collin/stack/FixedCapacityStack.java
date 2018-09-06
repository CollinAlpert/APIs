package de.collin.stack;

import java.util.EmptyStackException;

/**
 * Custom implementation of a stack with a fixed capacity.
 *
 * @param <T> The type of the Stack.
 * @author Collin Alpert
 * @see de.collin.stack.Stackable
 */
public class FixedCapacityStack<T> implements Stackable<T> {

	private T[] data;
	private int head;

	/**
	 * Constructor for defining the capacity.
	 *
	 * @param capacity The capacity of the stack.
	 */
	public FixedCapacityStack(int capacity) {
		data = (T[]) new Object[capacity];
		head = -1;
	}

	/**
	 * Constructor for defining the capacity and the first element.
	 *
	 * @param capacity     The capacity of the stack.
	 * @param firstElement The first element in the stack.
	 */
	public FixedCapacityStack(int capacity, T firstElement) {
		this(capacity);
		push(firstElement);
	}

	/**
	 * Pushes (adds) an element to the top of the stack.
	 *
	 * @param element The element to be added.
	 */
	@Override
	public void push(T element) {
		if (head == data.length - 1) {
			throw new RuntimeException("Stack is full.");
		}
		head++;
		data[head] = element;
	}

	/**
	 * Pops (removes and returns) the top of the stack.
	 *
	 * @return The top element on the stack.
	 */
	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T element = data[head];
		data[head] = null;
		head--;
		return element;
	}

	/**
	 * Returns the top of the stack.
	 *
	 * @return The first element on the stack.
	 */
	@Override
	public T top() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return data[head];
	}

	/**
	 * Checks if the stack is empty.
	 *
	 * @return <code>True</code> if there are elements in the stack, otherwise <code>false</code>.
	 */
	@Override
	public boolean isEmpty() {
		return head == -1;
	}

	/**
	 * @return the number of elements in this stack.
	 */
	@Override
	public int size() {
		return head + 1;
	}
}