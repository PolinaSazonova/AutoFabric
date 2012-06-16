package ru.nsu.ccfit.sazonova.controller;

import ru.nsu.ccfit.sazonova.autofabric.Warehouse;
import ru.nsu.ccfit.sazonova.view.View;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 16.06.12
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class Controller implements Observer{

    Warehouse warehouse;
    View view;

    public Controller(Warehouse _warehouse, View _view){
        warehouse = _warehouse;
        view = _view;
        warehouse.getObservable().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        view.update((Warehouse)o,arg);
    }
}
