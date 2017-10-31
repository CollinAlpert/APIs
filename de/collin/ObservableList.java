package de.collin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class ObservableList<T> extends ArrayList<T> {

    private Consumer<T> addListener;
    private Consumer<T> removeListener;

    public ObservableList() {
        addListener = null;
        removeListener = null;
    }

    @SafeVarargs
    public ObservableList(T... elements) {
        addListener = null;
        removeListener = null;
        Collections.addAll(this, elements);
    }

    public ObservableList(ArrayList<T> elements) {
        addListener = null;
        removeListener = null;
        this.addAll(elements);
    }

    @Override
    public boolean add(T element) {
        super.add(element);
        addListener.accept(element);
        return true;
    }

    @Override
    public T remove(int index) {
        T returnValue = this.get(index);
        removeListener.accept(returnValue);
        super.remove(index);
        return returnValue;
    }

    public void setAddListener(Consumer<T> addListener) {
        this.addListener = addListener;
    }

    public void setRemoveListener(Consumer<T> removeListener) {
        this.removeListener = removeListener;
    }

    public Consumer<T> getAddListener() {
        return addListener;
    }

    public Consumer<T> getRemoveListener() {
        return removeListener;
    }
}
