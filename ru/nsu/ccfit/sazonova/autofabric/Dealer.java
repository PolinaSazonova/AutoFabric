package ru.nsu.ccfit.sazonova.autofabric;

import java.util.logging.Level;
import java.util.logging.Logger;

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
    Logger logger;
    boolean makeLog;
    int id;

    public Dealer(int _frequency, AutoWarehouse _autoWarehouse, Logger _logger, boolean _makeLog, int _id) {
        super("Dealer");
        this.frequency = _frequency;
        this.autoWarehouse = _autoWarehouse;
        logger = _logger;
        makeLog = _makeLog;
        id = _id;
    }

    public void setFrequency(int _frequency) {
        this.frequency = _frequency;
    }

    @Override
    synchronized public void run() {
        while (true){
            try{
                sleep(frequency);
            }catch (InterruptedException e){
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            Auto auto = (Auto)autoWarehouse.getDetail();
            this.numberOfSold++;
            if (makeLog)
                logger.log(Level.INFO, "Dealer"+id+":"+"Auto"+auto.getId()+"(Body:"+auto.getCarcass().getId()+", Motor:"+auto.getCarcass().getId()+", Accessory:"+auto.getAccessories().getId()+")");
        }
    }
}
