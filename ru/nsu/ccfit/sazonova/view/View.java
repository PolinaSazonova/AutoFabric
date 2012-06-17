package ru.nsu.ccfit.sazonova.view;

import ru.nsu.ccfit.sazonova.autofabric.Warehouse;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    JSlider autoFrequencySlider;

    JLabel dealersTakesAutoText;
    JLabel dealersTakesAutoCount;
    JSlider dealersFrequencySlider;

    JPanel generalPanel;
    
    JButton closeButton;

    public View(){
        motorInAllText = new JLabel("Motor in all");
        motorInAllCount = new JLabel("0");
        motorOnWarehouseText = new JLabel("Motor on warehouse");
        motorOnWarehouseCount = new JLabel("0");
        motorFrequencySlider = new JSlider(0, 200000);

        carcassInAllText = new JLabel("Carcass in all");
        carcassInAllCount = new JLabel("0");
        carcassOnWarehouseText = new JLabel("Carcass on warehouse");
        carcassOnWarehouseCount = new JLabel("0");
        carcassFrequencySlider = new JSlider(0, 200000);

        accessoriesInAllText = new JLabel("Accessories in all");
        accessoriesInAllCount = new JLabel("0");
        accessoriesOnWarehouseText = new JLabel("Accessories on warehouse");
        accessoriesOnWarehouseCount = new JLabel("0");
        accessoriesFrequencySlider = new JSlider(0, 200000);

        autoInAllText = new JLabel("Auto in all");
        autoInAllCount = new JLabel("0");
        autoOnWarehouseText = new JLabel("Auto on warehouse");
        autoOnWarehouseCount = new JLabel("0");
        autoFrequencySlider = new JSlider(0, 200000);
        
        dealersTakesAutoText = new JLabel("Dealers takes auto");
        dealersTakesAutoCount = new JLabel("0");
        dealersFrequencySlider = new JSlider(0, 200000);

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
        JPanel autoJPanel3 = new JPanel();
        autoJPanel3.add(autoFrequencySlider);

        JPanel dealersJPanel1 = new JPanel();
        dealersJPanel1.add(dealersTakesAutoText);
        dealersJPanel1.add(dealersTakesAutoCount);
        JPanel dealersJPanel2 = new JPanel();
        dealersJPanel2.add(dealersFrequencySlider);

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
        generalPanel.add(autoJPanel3);
        generalPanel.add(dealersJPanel1);
        generalPanel.add(dealersJPanel2);

        generalPanel.add(closeButton);

        generalPanel.setLayout(new BoxLayout(generalPanel, BoxLayout.Y_AXIS));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.add(generalPanel);
        this.setSize(300,700);
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
            dealersTakesAutoCount.setText(String.valueOf(_warehouse.getNumberInAll()));
        }
    }
}
