package ru.nsu.ccfit.sazonova.autofabric;

/**
 * Created with IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class Accessories implements Detail {
    int id;
    private static int count = 0;

    public Accessories() {
        this.id = count++;
    }

    @Override
    public int getId() {
        return this.id;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
