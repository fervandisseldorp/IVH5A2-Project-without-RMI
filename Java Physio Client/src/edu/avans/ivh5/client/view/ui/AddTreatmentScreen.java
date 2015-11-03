/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author ferdinand
 */
public class AddTreatmentScreen extends JFrame {
    private JPanel completepanel, panel1top, panel2top;
    private JLabel therapistsLabel, klantLabel;
    private JComboBox comboBox;
    private JTextField searchField;
    
    
    public AddTreatmentScreen(){
        
        setUI();
    }
    
    private void setUI(){
        setSize(400, 600);
        setTitle("nieuwe behandeling");
        setLocationRelativeTo(null);
        add(createTreatmentInfoPanel() );
        
        
    }
    
    private JPanel createTreatmentInfoPanel() {
        Border border = BorderFactory.createLineBorder(Color.black);
        completepanel = new JPanel();
        panel1top = new JPanel();
        panel1top.setSize(100, 300);
        panel1top.setBorder(border);
        therapistsLabel = new JLabel("Therapists");
        comboBox = new JComboBox();
        panel1top.add(therapistsLabel);
        panel1top.add(comboBox);
        panel2top = new JPanel();
        panel2top.setBounds(310, 0, 100, 300);
        panel2top.setBorder(border);
        searchField = new JTextField(10);
        panel2top.add(searchField);
        
        completepanel.add(panel1top, panel2top);
        return completepanel;
    }
    
}
