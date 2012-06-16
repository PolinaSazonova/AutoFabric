package ru.nsu.ccfit.sazonova.autofabric;

import ru.nsu.ccfit.sazonova.threadpool.Task;

import static java.lang.Thread.sleep;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 16.06.12
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */
public class FactoryTask implements Task {
    private String name;
    WarehouseController warehouseController;

    public FactoryTask(String _name, WarehouseController _warehouseController) {
        this.name = _name;
        warehouseController = _warehouseController;
    }

    @Override
    public String getName() {
        return this.name;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void performWork() throws InterruptedException {
        sleep(warehouseController.time);
        warehouseController.autoWarehouse.add(new Auto((Motor)warehouseController.motorWarehouse.getDetail(),
                (Accessories)warehouseController.accessoriesWarehouse.getDetail(),
                (Carcass)warehouseController.carcassWarehouse.getDetail()));
        System.out.print("Auto is made");
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
