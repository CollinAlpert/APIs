package de.collin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * @param <T> The type of the list.
 * @author Collin Alpert
 */
public class ObservableList<T> extends ArrayList<T> {

	private Consumer<T> addListener;
	private Consumer<T> removeListener;

	/**
	 * Empty constructor for list creation.
	 */
	public ObservableList() {
		super();
	}

	/**
	 * Constructor for adding multiple elements to the initial list.
	 *
	 * @param elements Elements to be added initially.
	 */
	@SafeVarargs
	public ObservableList(T... elements) {
		super();
		Collections.addAll(this, elements);
	}

	/**
	 * Constructor for transferring an old list to this new list.
	 *
	 * @param elements The elements the initial list should contain.
	 */
	public ObservableList(List<T> elements) {
		super(elements);
	}

	/**
	 * Override of the add method to perform an action when an element is added to the list.
	 *
	 * @param element The element to add
	 * @return <code>True</code> if adding is successful. Otherwise an exception will be thrown.
	 */
	@Override
	public boolean add(T element) {
		super.add(element);
		if (addListener != null) {
			addListener.accept(element);
		}
		return true;
	}

	/**
	 * Override of the remove method to perform an action when an element is removed from the list.
	 *
	 * @param index The index of the element to remove.
	 * @return The removed element.
	 */
	@Override
	public T remove(int index) {
		T returnValue = super.remove(index);
		if (removeListener != null) {
			removeListener.accept(returnValue);
		}
		return returnValue;
	}

	/**
	 * Override of the remove method to perform an action when an element is removed from the list.
	 *
	 * @param o The object to remove from the list.
	 * @return THe removed element.
	 */
	@Override
	public boolean remove(Object o) {
		T returnValue = this.get(indexOf(o));
		if (removeListener != null) {
			removeListener.accept(returnValue);
		}
		return super.remove(o);
	}

	/**
	 * Manually executes the action that usually gets executed when an element gets added to the list.
	 */
	public void fireOnAddAction(T element) {
		if (addListener != null) {
			addListener.accept(element);
		}
	}

	/**
	 * Manually executes the action that usually gets executed when an element gets removed from the list.
	 */
	public void fireOnRemoveAction(T element) {
		if (removeListener != null) {
			removeListener.accept(element);
		}
	}

	public Consumer<T> getAddListener() {
		return addListener;
	}

	public void setAddListener(Consumer<T> addListener) {
		this.addListener = addListener;
	}

	public Consumer<T> getRemoveListener() {
		return removeListener;
	}

	public void setRemoveListener(Consumer<T> removeListener) {
		this.removeListener = removeListener;
	}

	/**
	 * Appends a {@link Consumer<T>} to the existing add-listener.
	 *
	 * @param addListener The {@link Consumer<T>} to be added.
	 */
	public void addAddListener(Consumer<T> addListener) {
		if (this.addListener == null)
			this.addListener = addListener;
		else this.addListener.andThen(addListener);
	}

	/**
	 * Appends a {@link Consumer<T>} to the existing remove-listener.
	 *
	 * @param removeListener The {@link Consumer<T>} to be added.
	 */
	public void addRemoveListener(Consumer<T> removeListener) {
		if (this.removeListener == null)
			this.removeListener = removeListener;
		else this.removeListener.andThen(removeListener);
	}

	/**
	 * Clears the add-listener.
	 */
	public void removeAddListener() {
		this.addListener = null;
	}

	/**
	 * Clears the remove-listener.
	 */
	public void removeRemoveListener() {
		this.removeListener = null;
	}
}
