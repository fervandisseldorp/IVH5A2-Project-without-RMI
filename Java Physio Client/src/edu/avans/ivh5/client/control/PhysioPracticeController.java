/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.api.PracticeManagerClientIF;
import edu.avans.ivh5.client.view.ui.CompanyInfoPanel;
import edu.avans.ivh5.shared.model.domain.PhysioPractice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Sjonn
 */
public class PhysioPracticeController implements ActionListener, KeyListener {
    private final PracticeManagerClientIF manager;
    private CompanyInfoPanel parentScreen;
    

    public PhysioPracticeController(PracticeManagerClientIF manager) {
        this.manager = manager;
        PhysioPractice practice = new PhysioPractice();
    }

    public void setUIRef(CompanyInfoPanel screen) {
        parentScreen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public boolean save(){
        
        
        return false;
    }
}