package de.collin.stack;

/**
 * @author Collin Alpert
 */
public interface Stackable<T> {
	void push(T element);

	T pop();

	T top();

	boolean isEmpty();

	int size();
}
