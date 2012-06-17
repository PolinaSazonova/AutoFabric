package ru.nsu.ccfit.sazonova.view;

import ru.nsu.ccfit.sazonova.autofabric.Factory;
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
    JPanel motorPanel;
    
    JButton closeButton;

    public View(){
        motorInAllText = new JLabel("Motor in all");
        motorInAllCount = new JLabel("0");
        motorOnWarehouseText = new JLabel("Motor on warehouse");
        motorOnWarehouseCount = new JLabel("0");
        motorPanel = new JPanel();



        closeButton = new JButton("EXIT");
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        JPanel jPanel = new JPanel();
        jPanel.add(motorInAllText);
        jPanel.add(motorInAllCount);
        motorPanel.add(jPanel);
        motorPanel.add(closeButton);
        motorPanel.setLayout(new BoxLayout(motorPanel, BoxLayout.Y_AXIS));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.add(motorPanel);
        this.setSize(300,300);
    }
    
    public void update(Warehouse _warehouse, Object arg){
        if(("motor").equals((String)arg))   {
            motorInAllCount.setText(String.valueOf(_factory.getNumberOfDetail()));
            motorOnWarehouseCount.setText(String.valueOf(_warehouse.getCountOfDetails()));
        }
    }
}
