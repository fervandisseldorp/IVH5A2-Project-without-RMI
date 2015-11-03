/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author ferdinand
 */
public class AddTreatmentScreen extends JFrame {
    private JPanel completepanel, panel1top, panel2top;
    private JLabel therapistsLabel, klantLabel, idLabel, firstnameLabel, lastnameLabel, telLabel, emailLabel;
    private JComboBox comboBox;
    private JTextField searchField;
    
    
    public AddTreatmentScreen(){
        setResizable(false);
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
        completepanel.setLayout(null);
        
        panel1top = new JPanel();
        panel1top.setLayout( new GridLayout(2,1,5,5));
        panel1top.setBounds(5,0, 180, 100);
        panel1top.setBorder(border);
        therapistsLabel = new JLabel("Therapists");
        comboBox = new JComboBox();
        panel1top.add(therapistsLabel);
        panel1top.add(comboBox);
        
        panel2top = new JPanel();
        panel2top.setLayout(new GridLayout(2,1,5,5));
        panel2top.setBounds(215, 0, 395, 100);
        panel2top.setBorder(border);
        searchField = new JTextField(10);
        klantLabel = new JLabel("Klant:");
        panel2top.add(klantLabel);
        panel2top.add(searchField);
        
        completepanel.add(panel1top);
        completepanel.add(panel2top);
        
        idLabel = new JLabel("ID");
        idLabel.setBounds(5, 120, 160, 20);
        completepanel.add(idLabel);
        firstnameLabel = new JLabel("voornaam");
        firstnameLabel.setBounds(5, 140, 160, 20);
        completepanel.add(firstnameLabel);
        lastnameLabel = new JLabel("achternaam");
        telLabel = new JLabel("telNr");
        emailLabel = new JLabel("email");
        
        
        
        return completepanel;
        
        
    }
    
}
