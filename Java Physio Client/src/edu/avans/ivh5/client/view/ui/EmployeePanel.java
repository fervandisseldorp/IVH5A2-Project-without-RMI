/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.api.EmployeeManagerClientIF;
import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.control.TherapistController;
import edu.avans.ivh5.shared.model.domain.Employee;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * EmployeePanel is a part of the MainTabbedPaneScreen
 * The Panel contains everything you need in order to
 * @author bernd_000
 */
public class EmployeePanel extends JPanel {

    private JButton logoutButton, addButton, alterButton, deleteButton;
    private JFrame parentFrame;
    private JTable fysioTable;
    private JMenuItem alter, delete;
    private TherapistController controller;
    private EmployeeManagerClientIF manager;

    /**
     * EmployeePanel creates the subpanels and adds them to itself
     * It also contains a reference to the parent of the panel which
     * is needed to log out
     * @param parentFrame 
     */
    public EmployeePanel(JFrame parentFrame, TherapistController controller, EmployeeManagerClientIF manager) {
        this.controller = controller;
        controller.setUIRef(this);
        this.manager = manager;
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());
        add(createNorthPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
    }

    /**
     * createNorthPanel creates a panel which contains everything
     * seen at the top part of the screen
     * @return 
     */
    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 5, 10, 10));

        // row 1
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        logoutButton = new JButton("Log uit");
        logoutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
            }

        });
        panel.add(logoutButton);
        // end of row 1

        // row 2
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        addButton = new JButton("Toevoegen");
        addButton.setActionCommand("saveEmployee");
        addButton.addActionListener(controller);
        panel.add(addButton);

        alterButton = new JButton("Wijzig");
        alterButton.setActionCommand("alter");
        alterButton.addActionListener(controller);
        panel.add(alterButton);

        deleteButton = new JButton("Verwijder");
        panel.add(deleteButton);
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(controller);
        // end of row 2

        //row 3
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 3

        return panel;
    }
    
    /**
     * createCenterPanel creates a panel which contains everything
     * seen at the center part of the screen
     * @return 
     */
    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 5));
        JLabel label = new JLabel("Fysiotherapeuten: ");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        northPanel.add(label);

        JPanel centerPanel = new JPanel(new GridLayout(1, 1));
        centerPanel.setBorder(new EmptyBorder(15, 10, 0, 10));

        Object rowData[][] = {{"1", "John op 't Hof", "0612345678", "jhof@avans.nl"},
        {"1001", "Michel Rijvers", "0687654321", "mrijvers@avans.nl"}};
        Object columnNames[] = {"ID", "Naam", "Telefoonnummer", "Email"};
        DefaultTableModel dtm = new DefaultTableModel();
        fysioTable = new JTable(rowData, columnNames);
        fysioTable.setFillsViewportHeight(true);
        fysioTable.getTableHeader().setBackground(Color.CYAN);
        fysioTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    int row = fysioTable.rowAtPoint(new Point(e.getX(), e.getY()));
                    // if the row is empty it will return -1
                    // you will not be able to right click on an empty row
                    if (row != -1) {
                        createRightClickMenu(row).show(fysioTable, e.getX(), e.getY());
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        // Make the table vertically scrollable
        JScrollPane scrollPane = new JScrollPane(fysioTable);

        centerPanel.add(scrollPane);

        // add the panels to the mainpanel
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }

    /**
     * createRightClickMenu creates a menu which gives you the options 
     * to alter or delete the employee on which you performed the right click
     * @param row
     * @return 
     */
    private JPopupMenu createRightClickMenu(int row) {
        JPopupMenu menu = new JPopupMenu();

        String name = "";

        try {
            name = fysioTable.getValueAt(row, 1) + "";
        } catch (Exception ex) {
        }

        alter = new JMenuItem("Wijzig " + name);
        alter.setName("" + row);
        alter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = Integer.parseInt(alter.getName());
                alterEmployee(row);
            }

        });

        delete = new JMenuItem("Verwijder " + name);
        delete.setName("" + row);
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = Integer.parseInt(alter.getName());
                //deleteEmployee();
            }

        });

        menu.add(alter);
        menu.add(delete);

        return menu;
    }

    /**
     * alterEmployee get all the information of a employee
     * from the JTable and opens the screen to alter that information
     * @param row 
     */
    private void alterEmployee(int row) {
        String id = (String) fysioTable.getValueAt(row, 0);
        String name = (String) fysioTable.getValueAt(row, 1);
        
        // split the name at a space
        String[] splittedName = name.split(" ");
        // the 'word' before the first space is seen as the first name
        String firstName = splittedName[0];
        // everything else is concatinated into one string
        // and will be seen as the last name
        String lastName = "";
        for (int index = 1; index < splittedName.length; index++) {
            lastName += splittedName[index] + " ";
        }
        
        String phoneNumber = (String) fysioTable.getValueAt(row, 2);
        String email = (String) fysioTable.getValueAt(row, 3);

        AddEmployeeScreen alterEmployeeGUI = new AddEmployeeScreen(new TherapistController(manager), "alterEmployee", id, firstName, lastName, phoneNumber, email);
    }

    public String getEmployeeID() {
        return (String) fysioTable.getValueAt(fysioTable.getSelectedRow(), 0);
    }

}
