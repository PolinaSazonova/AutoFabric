package ru.nsu.ccfit.sazonova.autofabric;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class Carcass implements Detail{
    int id;

    public Carcass(int _id) {
        this.id = _id;
    }

    @Override
    public int getId() {
        //To change body of implemented methods use File | Settings | File Templates.
        return this.id;
    }
}
