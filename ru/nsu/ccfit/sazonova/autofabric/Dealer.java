package ru.nsu.ccfit.sazonova.autofabric;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 17.06.12
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
public class Dealer extends Thread{
    private int frequency;
    private AutoWarehouse autoWarehouse;
    int numberOfSold = 1;

    public Dealer(int _frequency, AutoWarehouse _autoWarehouse) {
        super("Dealer");
        this.frequency = _frequency;
        this.autoWarehouse = _autoWarehouse;
    }

    @Override
    synchronized public void run() {
        while (true){
            try{
                sleep(frequency);
            }catch (InterruptedException e){
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            autoWarehouse.getDetail();
            this.numberOfSold++;
        }
    }
}
