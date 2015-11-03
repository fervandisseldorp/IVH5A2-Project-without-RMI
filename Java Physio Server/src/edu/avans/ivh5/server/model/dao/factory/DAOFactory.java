/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.factory;

import edu.avans.ivh5.server.model.dao.api.EmployeeDAOIF;
import edu.avans.ivh5.server.model.dao.api.SessionDAOIF;
import edu.avans.ivh5.server.model.dao.api.TreatmentDAOIF;
import edu.avans.ivh5.server.model.dao.api.UserDAOIF;

/**
 *
 * @author bernd_000
 */
public abstract class DAOFactory {

    public static DAOFactory getDAOFactory(String factoryClassName) {

        DAOFactory factoryInstance = null;

        try {
            Class<?> factoryClass = Class.forName(factoryClassName);
            factoryInstance = (DAOFactory) factoryClass.newInstance();
        } catch (ClassNotFoundException e) {
        } catch (Exception e) {
        }

        return factoryInstance;
    }

    public abstract UserDAOIF getUserDAO();
    
    public abstract EmployeeDAOIF getEmployeeDAO();
    
    public abstract SessionDAOIF getSessionDAO();
    
    public abstract TreatmentDAOIF getTreatmentDAO();
}
