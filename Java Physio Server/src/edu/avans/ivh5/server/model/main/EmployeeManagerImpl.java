/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.main;

import edu.avans.ivh5.api.EmployeeManagerClientIF;
import edu.avans.ivh5.server.model.dao.api.EmployeeDAOIF;
import edu.avans.ivh5.server.model.dao.factory.DAOFactory;
import edu.avans.ivh5.shared.model.domain.Employee;

/**
 *
 * @author ferdinand
 */
public class EmployeeManagerImpl implements EmployeeManagerClientIF{
    private final DAOFactory daoFactory;
    
    
    public EmployeeManagerImpl(){
        daoFactory = DAOFactory.getDAOFactory("edu.avans.ivh5.server.model.dao.xml.dom.XmlDOMDAOFactory");
        
    }
    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("Create employeeDao with daofactory");
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        System.out.println("dao saving employee");
        dao.saveEmployee(employee);
    }

    @Override
    public void alterEmployee(Employee employee) {
        System.out.println("alter employee in manager");
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        System.out.println("dao alter employee");
        dao.alterEmployee(employee);
    }

    @Override
    public void removeEmployee(String employeeID) {
        System.out.println("delete employee in manager");
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        System.out.println("dao delete employee");
        dao.deleteEmployee(employeeID);
    }
    
}
