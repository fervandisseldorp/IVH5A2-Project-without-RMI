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
    private JPanel paneeltop, paneelmid, paneladdnew, paneltable, panelbot,
            panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9,
            panel10, panel11, panel12;
    private JComboBox therapists;
    
    public AddTreatmentScreen(){
        //CONSTRUCTOR fRAME   
        
        init();
    }
    
    
    private void init(){
        setSize(400, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel panel = createAddTreatmentPanel();
        setContentPane( panel );

        setVisible(true);
    }
    
    public JPanel createAddTreatmentPanel(){
        JPanel panel = new JPanel();
        panel.setLayout( new GridLayout(7,1,5,5) );
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        
        paneeltop = new JPanel( new GridLayout(3,2,10,10));
        paneelmid = new JPanel( new GridLayout(1,1,5,5));
        paneladdnew = new JPanel( new GridLayout(2,1, 5, 5 ));
        paneltable = new JPanel( new GridLayout(1,1, 5, 5 ));
        panelbot = new JPanel( new GridLayout(2, 1, 5, 5));
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();
        panel11= new JPanel();
        panel12= new JPanel();
        
    
        panel1.setBorder(border);
        therapists = new JComboBox();
        panel1.add(therapists);
        
        panel2.setBorder(border);
        JTextField searchfield = new JTextField();
        panel1.add( searchfield );
        
        JLabel label1 = new JLabel("ID");
        panel3.add( label1 );
        
        JButton saveButton = new JButton();
        panel11.add( saveButton);
        
        JButton cancelButton = new JButton();
        panel12.add( cancelButton );
                
        
        paneeltop.add( panel1);
        paneeltop.add( panel2);
        paneeltop.add( panel3);
        paneeltop.add( panel4);
        paneeltop.add( panel5);
        paneeltop.add( panel6);
        paneelmid.add( panel7);
        paneladdnew.add( panel8);
        paneladdnew.add( panel9 );
        paneltable.add( panel10 ); 
        panelbot.add( panel11);
        panelbot.add( panel12);
       
        panel.add(paneeltop);
        panel.add(paneelmid);
        panel.add(paneladdnew);
        panel.add(paneltable);
        panel.add(panelbot);
        
        
        return panel;
    }
    
}
   
