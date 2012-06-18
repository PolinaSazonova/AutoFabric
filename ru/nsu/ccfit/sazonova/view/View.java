package ru.nsu.ccfit.sazonova.view;

import ru.nsu.ccfit.sazonova.autofabric.AutoWarehouse;
import ru.nsu.ccfit.sazonova.autofabric.Factory;
import ru.nsu.ccfit.sazonova.autofabric.Warehouse;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Полина
 * Date: 16.06.12
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
public class View extends JFrame{
    JLabel motorInAllText;
    JLabel motorInAllCount;
    JLabel motorOnWarehouseText;
    JLabel motorOnWarehouseCount;
    JSlider motorFrequencySlider;

    JLabel carcassInAllText;
    JLabel carcassInAllCount;
    JLabel carcassOnWarehouseText;
    JLabel carcassOnWarehouseCount;
    JSlider carcassFrequencySlider;

    JLabel accessoriesInAllText;
    JLabel accessoriesInAllCount;
    JLabel accessoriesOnWarehouseText;
    JLabel accessoriesOnWarehouseCount;
    JSlider accessoriesFrequencySlider;

    JLabel autoInAllText;
    JLabel autoInAllCount;
    JLabel autoOnWarehouseText;
    JLabel autoOnWarehouseCount;

    JLabel dealersTakesAutoText;
    JLabel dealersTakesAutoCount;

    JPanel generalPanel;
    
    JButton closeButton;

    Map<String,LinkedList<Factory>> factoryMap;

    public void takeFactoryMap(String args, LinkedList<Factory> _factory){
        factoryMap.put(args, _factory);
    }

    public View(){
        factoryMap = new HashMap<String, LinkedList<Factory>>();

        motorInAllText = new JLabel("Motor in all");
        motorInAllCount = new JLabel("0");
        motorOnWarehouseText = new JLabel("Motor on warehouse");
        motorOnWarehouseCount = new JLabel("0");
        motorFrequencySlider = new JSlider(0, 50000);
        motorFrequencySlider.setMajorTickSpacing(25000);
        motorFrequencySlider.setMinorTickSpacing(5000);
        motorFrequencySlider.setPaintTicks(true);
        motorFrequencySlider.setPaintLabels(true);
        motorFrequencySlider.setSnapToTicks(true);
        motorFrequencySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider)e.getSource();
                int value = slider.getValue();
                for(Factory d: factoryMap.get("MotorFactory"))
                    d.setFrequency(value);
            }
        });

        carcassInAllText = new JLabel("Carcass in all");
        carcassInAllCount = new JLabel("0");
        carcassOnWarehouseText = new JLabel("Carcass on warehouse");
        carcassOnWarehouseCount = new JLabel("0");
        carcassFrequencySlider = new JSlider(0, 50000);
        carcassFrequencySlider.setMajorTickSpacing(25000);
        carcassFrequencySlider.setMinorTickSpacing(5000);
        carcassFrequencySlider.setPaintTicks(true);
        carcassFrequencySlider.setPaintLabels(true);
        carcassFrequencySlider.setSnapToTicks(true);
        carcassFrequencySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider)e.getSource();
                int value = slider.getValue();
                for(Factory d: factoryMap.get("CarcassFactory"))
                    d.setFrequency(value);
            }
        });

        accessoriesInAllText = new JLabel("Accessories in all");
        accessoriesInAllCount = new JLabel("0");
        accessoriesOnWarehouseText = new JLabel("Accessories on warehouse");
        accessoriesOnWarehouseCount = new JLabel("0");
        accessoriesFrequencySlider = new JSlider(0, 50000);
        accessoriesFrequencySlider.setMajorTickSpacing(25000);
        accessoriesFrequencySlider.setMinorTickSpacing(5000);
        accessoriesFrequencySlider.setPaintTicks(true);
        accessoriesFrequencySlider.setPaintLabels(true);
        accessoriesFrequencySlider.setSnapToTicks(true);
        accessoriesFrequencySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider)e.getSource();
                int value = slider.getValue();
                for(Factory d: factoryMap.get("AccessoriesFactory"))
                    d.setFrequency(value);
            }
        });

        autoInAllText = new JLabel("Auto in all");
        autoInAllCount = new JLabel("0");
        autoOnWarehouseText = new JLabel("Auto on warehouse");
        autoOnWarehouseCount = new JLabel("0");

        dealersTakesAutoText = new JLabel("Dealers takes auto");
        dealersTakesAutoCount = new JLabel("0");

        closeButton = new JButton("EXIT");
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        JPanel motorJPanel1 = new JPanel();
        motorJPanel1.add(motorInAllText);
        motorJPanel1.add(motorInAllCount);
        JPanel motorJPanel2 = new JPanel();
        motorJPanel2.add(motorOnWarehouseText);
        motorJPanel2.add(motorOnWarehouseCount);
        JPanel motorJPanel3 = new JPanel();
        motorJPanel3.add(motorFrequencySlider);

        JPanel carcassJPanel1 = new JPanel();
        carcassJPanel1.add(carcassInAllText);
        carcassJPanel1.add(carcassInAllCount);
        JPanel carcassJPanel2 = new JPanel();
        carcassJPanel2.add(carcassOnWarehouseText);
        carcassJPanel2.add(carcassOnWarehouseCount);
        JPanel carcassJPanel3 = new JPanel();
        carcassJPanel3.add(carcassFrequencySlider);

        JPanel accessoriesJPanel1 = new JPanel();
        accessoriesJPanel1.add(accessoriesInAllText);
        accessoriesJPanel1.add(accessoriesInAllCount);
        JPanel accessoriesJPanel2 = new JPanel();
        accessoriesJPanel2.add(accessoriesOnWarehouseText);
        accessoriesJPanel2.add(accessoriesOnWarehouseCount);
        JPanel accessoriesJPanel3 = new JPanel();
        accessoriesJPanel3.add(accessoriesFrequencySlider);

        JPanel autoJPanel1 = new JPanel();
        autoJPanel1.add(autoInAllText);
        autoJPanel1.add(autoInAllCount);
        JPanel autoJPanel2 = new JPanel();
        autoJPanel2.add(autoOnWarehouseText);
        autoJPanel2.add(autoOnWarehouseCount);

        JPanel dealersJPanel1 = new JPanel();
        dealersJPanel1.add(dealersTakesAutoText);
        dealersJPanel1.add(dealersTakesAutoCount);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);

        generalPanel = new JPanel();

        generalPanel.add(motorJPanel1);
        generalPanel.add(motorJPanel2);
        generalPanel.add(motorJPanel3);
        generalPanel.add(carcassJPanel1);
        generalPanel.add(carcassJPanel2);
        generalPanel.add(carcassJPanel3);
        generalPanel.add(accessoriesJPanel1);
        generalPanel.add(accessoriesJPanel2);
        generalPanel.add(accessoriesJPanel3);
        generalPanel.add(autoJPanel1);
        generalPanel.add(autoJPanel2);
        generalPanel.add(dealersJPanel1);

        generalPanel.add(buttonPanel);

        generalPanel.setLayout(new BoxLayout(generalPanel, BoxLayout.Y_AXIS));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Auto Factory");
        this.add(generalPanel);
        this.setSize(300,500);
    }
    
    public void update(Warehouse _warehouse, Object arg){
        if(("motor").equals((String)arg))   {
            motorInAllCount.setText(String.valueOf(_warehouse.getNumberInAll()));
            motorOnWarehouseCount.setText(String.valueOf(_warehouse.getCountOfDetails()));
        }

        if(("carcass").equals((String)arg))   {
            carcassInAllCount.setText(String.valueOf(_warehouse.getNumberInAll()));
            carcassOnWarehouseCount.setText(String.valueOf(_warehouse.getCountOfDetails()));
        }

        if(("accessories").equals((String)arg))   {
            accessoriesInAllCount.setText(String.valueOf(_warehouse.getNumberInAll()));
            accessoriesOnWarehouseCount.setText(String.valueOf(_warehouse.getCountOfDetails()));
        }

        if(("auto").equals((String)arg))   {
            autoInAllCount.setText(String.valueOf(_warehouse.getNumberInAll()));
            autoOnWarehouseCount.setText(String.valueOf(_warehouse.getCountOfDetails()));
        }

        if(("dealers").equals((String)arg))   {
            dealersTakesAutoCount.setText(String.valueOf(((AutoWarehouse) _warehouse).getNumberWasTaken()));
        }
    }
}
