/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.EmployeeDAOIF;
import edu.avans.ivh5.server.model.dao.api.SessionDAOIF;
import edu.avans.ivh5.server.model.dao.api.TreatmentDAOIF;
import edu.avans.ivh5.server.model.dao.api.UserDAOIF;
import edu.avans.ivh5.server.model.dao.factory.DAOFactory;

/**
 *
 * @author bernd_000
 */
public class XmlDOMDAOFactory extends DAOFactory {

    @Override
    public UserDAOIF getUserDAO() {
        return new XMLDOMUserDAO();
    }

    @Override
    public EmployeeDAOIF getEmployeeDAO() {
        return new XMLDOMEmployeeDAO();
    }

    @Override
    public SessionDAOIF getSessionDAO() {
        return new XMLDOMSessionDAO();
    }

    @Override
    public TreatmentDAOIF getTreatmentDAO() {
        return new XMLDOMTreatmentDAO();
    }
    
}
