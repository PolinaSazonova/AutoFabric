package ru.nsu.ccfit.sazonova.autofabric;

/**
 * Created with IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class CarcassFactory extends Thread {
    private int frequency;
    private Warehouse warehouse;
    int count;

    public CarcassFactory(int _frequency, Warehouse _warehouse) {
        super("CarcassFactory");
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
            warehouse.add(new Carcass(count++));
        }
    }
}
