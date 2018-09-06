package de.collin.stack;

import java.util.EmptyStackException;

/**
 * @author Collin Alpert
 * @param <T> The type of the Stack.
 * @see de.collin.stack.Stackable
 * @see de.collin.stack.LinkedListStackElement
 */
public class LinkedListStack<T> implements Stackable<T> {

	/**
	 * Element representing the head of the stack and the entry point for finding other elements.
	 */
	private LinkedListStackElement<T> head;
	private int elementCount;

	/**
	 * Constructor for creating an empty stack.
	 */
	public LinkedListStack() {
		elementCount = 0;
	}

	/**
	 * Pushes (adds) an element to the top of the stack.
	 * @param element The element to be added.
	 */
	@Override
	public void push(T element) {
		LinkedListStackElement<T> newElement = new LinkedListStackElement<>(element);
		newElement.setNext(head);
		head = newElement;
		elementCount++;
	}

	/**
	 * Pops (removes and returns) the top of the stack.
	 * @return The top element on the stack.
	 */
	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		LinkedListStackElement<T> firstElement = head;
		head = head.getNext();
		elementCount--;
		return firstElement.getValue();
	}

	/**
	 * Returns the top of the stack.
	 * @return The first element on the stack.
	 */
	@Override
	public T top() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return head.getValue();
	}

	/**
	 * Checks if the stack is empty.
	 * @return <code>True</code> if there are elements in the stack, otherwise <code>false</code>.
	 */
	@Override
	public boolean isEmpty() {
		return elementCount == 0;
	}

	/**
	 * @return the number of elements in this stack.
	 */
	@Override
	public int size() {
		return elementCount;
	}
}