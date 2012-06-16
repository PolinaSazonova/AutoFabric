package ru.nsu.ccfit.sazonova.autofabric;

import ru.nsu.ccfit.sazonova.controller.Controller;
import ru.nsu.ccfit.sazonova.view.View;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]){
        MotorWarehouse motorWarehouse = new MotorWarehouse(2);
        MotorFactory motorFactory = new MotorFactory(5000, motorWarehouse);
        motorFactory.start();

        CarcassWarehouse carcassWarehouse = new CarcassWarehouse(3);
        CarcassFactory carcassFactory = new CarcassFactory(7000, carcassWarehouse);
        carcassFactory.start();

        AccessoriesWarehouse accessoriesWarehouse = new AccessoriesWarehouse(4);
        AccessoriesFactory accessoriesFactory = new AccessoriesFactory(10000, accessoriesWarehouse);
        accessoriesFactory.start();

        AutoWarehouse autoWarehouse = new AutoWarehouse(5);

        WarehouseController warehouseController = new WarehouseController(15000,autoWarehouse, motorWarehouse,carcassWarehouse, accessoriesWarehouse);
        warehouseController.start();
        View view = new View();
        Controller controller = new Controller(motorWarehouse,view);

    }

}
