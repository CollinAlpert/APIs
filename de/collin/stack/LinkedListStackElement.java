package de.collin.stack;

/**
 * @author Collin Alpert
 * @param <T> The type of the stack element.
 * @see de.collin.stack.LinkedListStack
 */
public class LinkedListStackElement<T> {

	/**
	 * Reference to the next element in the stack.
	 */
	private LinkedListStackElement<T> next;
	private T value;

	/**
	 * Default constructor for creating an element of the stack with no value.
	 * As it has no "next" reference, it represents the last element of the stack.
	 */
	public LinkedListStackElement() {
		next = null;
		value = null;
	}

	/**
	 * Constructor for creating an element that represents the last element of a stack with the given value.
	 * @param value The value of this element.
	 */
	public LinkedListStackElement(T value) {
		next = null;
		this.value = value;
	}

	/**
	 * @return the reference to the next element in the stack.
	 */
	public LinkedListStackElement<T> getNext() {
		return next;
	}

	/**
	 * Sets the reference to the next element in the stack.
	 * @param next The next element in the stack.
	 */
	public void setNext(LinkedListStackElement<T> next) {
		this.next = next;
	}

	/**
	 * @return the value of this element.
	 */
	public T getValue() {
		return value;
	}
}