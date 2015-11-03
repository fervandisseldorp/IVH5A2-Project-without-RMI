/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.EmployeeManagerClientIF;
import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.AddEmployeeScreen;
import edu.avans.ivh5.client.view.ui.EmployeePanel;
import edu.avans.ivh5.client.view.ui.LoginScreen;
import edu.avans.ivh5.server.model.main.PhysioManagerImpl;
import edu.avans.ivh5.shared.model.domain.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ferdinand
 */
public class TherapistController implements ActionListener {
    
    private AddEmployeeScreen parentScreen;
    private EmployeePanel parentPanel;
    private EmployeeManagerClientIF manager;
    
    public TherapistController(EmployeeManagerClientIF manager){
        this.manager = manager;
    }
    public void saveEmployee(Employee employee){
        employee = parentScreen.getEmployee();
        
    }
    
    public void setUIRef(AddEmployeeScreen parentScreen){
        this.parentScreen = parentScreen;
    }
    
    public void setUIRef(EmployeePanel parentScreen) {
        this.parentPanel = parentScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("saveEmployee")) {
            System.out.println("actioncommand saveEmployee");
           new AddEmployeeScreen(this, "newEmployee");
        } else if (e.getActionCommand().equals("alter")) {
             System.out.println("actioncommand alter");
            new AddEmployeeScreen(this, "alterEmployee");;
        } else if (e.getActionCommand().equals("logout")){
             System.out.println("actioncommand logout");
            parentScreen.dispose();
            new LoginScreen( new LoginController((PhysioManagerClientIF) new PhysioManagerImpl()) );
        } else if (e.getActionCommand().equals("delete")){
             System.out.println("actioncommand delete");
            manager.removeEmployee(parentPanel.getEmployeeID());
        } else if (e.getActionCommand().equals("confirmSave")){
             System.out.println("actioncommand confirmsave");
            manager.saveEmployee(parentScreen.getEmployee());
            parentScreen.dispose();
        } else if (e.getActionCommand().equals("confirmAlter")){
             System.out.println("actioncommand confirmAlter");
            manager.alterEmployee(parentScreen.getEmployee());
            parentScreen.dispose();
        } else if (e.getActionCommand().equals("cancel")){
             System.out.println("actioncommand cancel");
            parentScreen.dispose();
        }

        
    }
    
    
}
