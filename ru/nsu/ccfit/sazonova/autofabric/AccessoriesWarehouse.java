package ru.nsu.ccfit.sazonova.autofabric;

import java.util.LinkedList;
import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class AccessoriesWarehouse extends Observable implements Warehouse {

    LinkedList<Accessories> store;
    int size;
    int numberInAll = 1;

    public AccessoriesWarehouse(int _size) {
        this.store = new LinkedList<Accessories>();
        size = _size;
    }

    @Override
    public boolean isFull() {
        return (size == store.size());  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getNumberInAll() {
        return this.numberInAll;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    synchronized public void add(Detail detail) {
        while(isFull())
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        store.add((Accessories) detail);
        setChanged();
        notifyObservers("accessories");
        notifyAll();
        System.out.print(store.size());
        this.numberInAll++;
    }

    @Override
    public int getCountOfDetails() {
        return store.size();
    }

    @Override
    synchronized public Detail getDetail() {
        while(store.isEmpty())
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        setChanged();
        notifyObservers("accessories");
        notifyAll();
        return store.removeFirst();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Observable getObservable() {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
