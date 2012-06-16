package ru.nsu.ccfit.sazonova.autofabric;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 16.06.12
 * Time: 11:37
 * To change this template use File | Settings | File Templates.
 */
public class Auto implements Detail{
    int id;
    Motor motor;
    Accessories accessories;
    Carcass carcass;
    private static int count = 0;

    public Auto(Motor _motor, Accessories _accessories, Carcass _carcass) {
        this.id = count++;
        this.motor = _motor;
        this.accessories = _accessories;
        this.carcass = _carcass;
    }

    public Motor getMotor() {
        return motor;
    }

    public Accessories getAccessories() {
        return accessories;
    }

    public Carcass getCarcass() {
        return carcass;
    }

    @Override
    public int getId() {
        return this.id;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
