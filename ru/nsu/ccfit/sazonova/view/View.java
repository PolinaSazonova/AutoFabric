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
    JLabel motor;
    JLabel motorWarehouse;
    JPanel panel;
    JButton close;

    public View(){
        motor = new JLabel("Motor count");
        motorWarehouse = new JLabel("0");
        panel = new JPanel();
        close = new JButton("EXIT");
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        JPanel yoba = new JPanel();
        yoba.add(motor);
        yoba.add(motorWarehouse);
        panel.add(yoba);
        panel.add(close);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.add(panel);
        this.setSize(300,300);
    }
    
    public void update(Warehouse _warehouse, Object arg){
        if(("motor").equals((String)arg))
            motorWarehouse.setText(String.valueOf(_warehouse.getCountOfDetails()));
    }
}
