/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.api.EmployeeManagerClientIF;
import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.control.ReportingController;
import edu.avans.ivh5.client.control.TherapistController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author bernd_000
 */
public class MainTabbedPaneScreen extends JFrame {
    
    private final PhysioManagerClientIF loginManager;
    private final EmployeeManagerClientIF employeeManager;
    
    public MainTabbedPaneScreen(PhysioManagerClientIF loginManager, EmployeeManagerClientIF employeeManager) {
        this.loginManager = loginManager;
        this.employeeManager = employeeManager;
        setTitle("Fysiopraktijk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        createTabs();
        
        setVisible(true);
    }
    
    private void createTabs() {
        JTabbedPane panes = new JTabbedPane();
        
        JPanel AgendaPanel = new AgendaPanel();
        JPanel TreatmentsPanel = new TreatmentPanel(this);
        JPanel OverviewPanel = new OverviewPanel(this, new ReportingController(loginManager));
        JPanel EmployeePanel = new EmployeePanel(this, new TherapistController(employeeManager), employeeManager);
        JPanel CompanyInfoPanel = new CompanyInfoPanel();
        
        panes.add("Agenda", AgendaPanel);
        panes.add("Behandelingen", TreatmentsPanel);
        panes.add("Overzichten", OverviewPanel);
        panes.add("Fysiotherapeuten", EmployeePanel);
        panes.add("Praktijkgegevens", CompanyInfoPanel);
        
        add(panes);
    }
}
