package ru.nsu.ccfit.sazonova.autofabric;

import java.util.Observable;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
public interface Warehouse {
    int getNumberInAll();
    boolean isFull();
    void add(Detail detail);
    int getCountOfDetails();
    Detail getDetail();
    Observable getObservable();
}
