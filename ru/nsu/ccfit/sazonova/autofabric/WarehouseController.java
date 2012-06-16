package ru.nsu.ccfit.sazonova.autofabric;

import ru.nsu.ccfit.sazonova.threadpool.ThreadPool;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 16.06.12
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public class WarehouseController extends Thread{
    AutoWarehouse autoWarehouse;
    MotorWarehouse motorWarehouse;
    CarcassWarehouse carcassWarehouse;
    AccessoriesWarehouse accessoriesWarehouse;
    ThreadPool threadPool;
    static int n;
    int time;

    public WarehouseController(int _time, AutoWarehouse _autoWarehouse, MotorWarehouse _motorWarehouse, CarcassWarehouse _carcassWarehouse, AccessoriesWarehouse _accessoriesWarehouse) {
        time = _time;
        this.autoWarehouse = _autoWarehouse;
        this.motorWarehouse = _motorWarehouse;
        this.carcassWarehouse = _carcassWarehouse;
        this.accessoriesWarehouse = _accessoriesWarehouse;
        threadPool = new ThreadPool();
        
    }

    @Override
    public void run() {
        while(true){
            synchronized (autoWarehouse){
                while(autoWarehouse.getCountOfDetails()+threadPool.getCountOfRunnableThread()+threadPool.getTaskQueueSize() == autoWarehouse.getSize())
                    try {
                        autoWarehouse.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                System.out.print("\nTasks"+(autoWarehouse.getSize()-(autoWarehouse.getCountOfDetails()+threadPool.getCountOfRunnableThread()+threadPool.getTaskQueueSize())));
                for(int i= 0;i<autoWarehouse.getSize()-(autoWarehouse.getCountOfDetails()+threadPool.getCountOfRunnableThread()+threadPool.getTaskQueueSize());i++)
                        threadPool.addTask(new FactoryTask("Task" + n++, this));

            }
        }
    }
}
