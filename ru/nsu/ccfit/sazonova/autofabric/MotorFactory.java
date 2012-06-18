package ru.nsu.ccfit.sazonova.autofabric;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
public class MotorFactory extends Thread implements Factory{
    int frequency;
    private Warehouse warehouse;
    int count;

    public MotorFactory(int _frequency, Warehouse _warehouse) {
        super("MotorFactory");
        this.frequency = _frequency;
        this.warehouse = _warehouse;
    }

    @Override
    synchronized public void run() {
        while (true){
        try{
        sleep(frequency);
        }catch (InterruptedException e){
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        warehouse.add(new Motor(count++));
        }
    }

    @Override
    public int getNumberOfDetail() {
        return this.count;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setFrequency(int _frequency) {
        this.frequency = _frequency;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
