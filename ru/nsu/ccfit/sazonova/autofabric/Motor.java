package ru.nsu.ccfit.sazonova.autofabric;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
public class Motor implements Detail{
    int id;

    @Override
    public int getId() {
        //To change body of implemented methods use File | Settings | File Templates.
        return this.id;
    }

    public Motor(int _id) {
        this.id = _id;
    }
}
