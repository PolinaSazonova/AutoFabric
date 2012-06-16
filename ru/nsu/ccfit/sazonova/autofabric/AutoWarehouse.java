package ru.nsu.ccfit.sazonova.autofabric;

import java.util.LinkedList;
import java.util.Observable;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 16.06.12
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */
public class AutoWarehouse extends Observable implements Warehouse{

    LinkedList<Auto> store;
    int size;

    @Override
    public Observable getObservable() {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public AutoWarehouse(int _size) {
        this.store = new LinkedList<Auto>();
        size = _size;
    }

    @Override
    public boolean isFull() {
        return (size == store.size());  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    synchronized public void add(Detail detail) {
        while(isFull())
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        store.add((Auto) detail);
        notifyAll();
        System.out.print(store.size());
    }

    @Override
    public int getCountOfDetails() {
        return store.size();
    }

    public int getSize() {
        return this.size;
    }

    @Override
    synchronized public Detail getDetail() {
        while(store.isEmpty())
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        notifyAll();
        return store.removeFirst();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
