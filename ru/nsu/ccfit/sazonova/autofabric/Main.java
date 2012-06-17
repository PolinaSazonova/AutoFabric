package ru.nsu.ccfit.sazonova.autofabric;

import ru.nsu.ccfit.sazonova.controller.Controller;
import ru.nsu.ccfit.sazonova.view.View;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 11.06.12
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]){
        Logger logger = Logger.getLogger(Main.class.getName());

        FileHandler fh = null;
        try {
            fh = new FileHandler("Dealerslog");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        logger.addHandler(fh);

        logger.setLevel(Level.ALL);

        InputStreamReader propReader = new InputStreamReader (Main.class.getResourceAsStream("data.properties"));
        Properties properties = new Properties();
        try {
            properties.load(propReader);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        int motorWarehouseSize = Integer.parseInt(properties.getProperty("MotorWarehouseSize"));
        int carcassWarehouseSize = Integer.parseInt(properties.getProperty("CarcassWarehouseSize"));
        int accessoriesWarehouseSize = Integer.parseInt(properties.getProperty("AccessoriesWarehouseSize"));
        int autoWarehouseSize = Integer.parseInt(properties.getProperty("AutoWarehouseSize"));
        int accessoriesSuppliers = Integer.parseInt(properties.getProperty("AccessoriesSuppliers"));
        int dealers = Integer.parseInt(properties.getProperty("Dealers"));
        int threadCount = Integer.parseInt(properties.getProperty("ThreadCount"));
        boolean makeLog = Boolean.parseBoolean(properties.getProperty("LogSale"));

        LinkedList<AccessoriesFactory> accessoriesSuppliersList = new LinkedList<AccessoriesFactory>();
        LinkedList<Dealer> dealersList = new LinkedList<Dealer>();

        MotorWarehouse motorWarehouse = new MotorWarehouse(motorWarehouseSize);
        MotorFactory motorFactory = new MotorFactory(5000, motorWarehouse);
        motorFactory.start();

        CarcassWarehouse carcassWarehouse = new CarcassWarehouse(carcassWarehouseSize);
        CarcassFactory carcassFactory = new CarcassFactory(7000, carcassWarehouse);
        carcassFactory.start();

        AccessoriesWarehouse accessoriesWarehouse = new AccessoriesWarehouse(accessoriesWarehouseSize);
        for (int i = 0; i < accessoriesSuppliers; i++) {
            AccessoriesFactory accessoriesFactory = new AccessoriesFactory(3000, accessoriesWarehouse);
            accessoriesFactory.start();
            accessoriesSuppliersList.add(accessoriesFactory);
        }

        AutoWarehouse autoWarehouse = new AutoWarehouse(autoWarehouseSize);
        
        for (int i = 0; i < dealers; i++) {
            Dealer dealer = new Dealer(15000, autoWarehouse, logger, makeLog, i);
            dealer.start();
            dealersList.add(dealer);
        }
        
        WarehouseController warehouseController = new WarehouseController(15000,autoWarehouse, motorWarehouse,carcassWarehouse, accessoriesWarehouse, threadCount);
        warehouseController.start();

        View view = new View();
        Controller controllerMotor = new Controller(motorWarehouse,view);
        Controller controllerAccessories = new Controller(accessoriesWarehouse,view);
        Controller controllerCarcass = new Controller(carcassWarehouse,view);
        Controller controllerAuto = new Controller(autoWarehouse,view);

        logger.fine("See you!");
    }

}
