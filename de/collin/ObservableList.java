package de.collin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class ObservableList<T> extends ArrayList<T> {

	private Consumer<T> addListener;
	private Consumer<T> removeListener;

	public ObservableList() {
	}

	@SafeVarargs
	public ObservableList(T... elements) {
		Collections.addAll(this, elements);
	}

	public ObservableList(ArrayList<T> elements) {
		this.addAll(elements);
	}

	@Override
	public boolean add(T element) {
		super.add(element);
		if (addListener != null)
			addListener.accept(element);
		return true;
	}

	@Override
	public T remove(int index) {
		T returnValue = super.remove(index);
		if (removeListener != null)
			removeListener.accept(returnValue);
		return returnValue;
	}


	@Override
	public boolean remove(Object o) {
		T returnValue = this.get(indexOf(o));
		if (removeListener != null)
			removeListener.accept(returnValue);
		return super.remove(o);
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

	public void addAddListener(Consumer<T> addListener) {
		if (this.addListener == null)
			this.addListener = addListener;
		else this.addListener.andThen(addListener);
	}

	public void addRemoveListener(Consumer<T> removeListener) {
		if (this.removeListener == null)
			this.removeListener = removeListener;
		else this.removeListener.andThen(removeListener);
	}

	public void removeAddListener() {
		this.addListener = null;
	}

	public void removeRemoveListener() {
		this.removeListener = null;
	}
}
