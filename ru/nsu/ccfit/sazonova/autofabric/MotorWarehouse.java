package ru.nsu.ccfit.sazonova.autofabric;

import java.util.LinkedList;
import java.util.Observable;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class MotorWarehouse  extends Observable implements Warehouse {

    LinkedList<Motor> store;
    int size;
    public static int numberInAll = 0;

    public MotorWarehouse(int _size) {
        this.store = new LinkedList<Motor>();
        size = _size;
    }

    public void setNumberInAll(int _numberInAll) {
        this.numberInAll = _numberInAll;
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
        store.add((Motor) detail);
        setChanged();
        notifyObservers("motor");
        notifyAll();
        System.out.print(store.size());
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
        notifyObservers("motor");
        notifyAll();
        return store.removeFirst();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Observable getObservable() {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
