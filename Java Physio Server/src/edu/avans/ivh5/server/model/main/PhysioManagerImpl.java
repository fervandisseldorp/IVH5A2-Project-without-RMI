/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.main;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.server.model.dao.api.UserDAOIF;
import edu.avans.ivh5.server.model.dao.factory.DAOFactory;

/**
 *
 * @author bernd_000
 */
public class PhysioManagerImpl implements PhysioManagerClientIF {

    private final DAOFactory daoFactory;
    private final PasswordManager passwordManager;
    
    public PhysioManagerImpl() {
        daoFactory = DAOFactory.getDAOFactory("edu.avans.ivh5.server.model.dao.xml.dom.XmlDOMDAOFactory");
        passwordManager = new PasswordManager();
    }
    
    @Override
    public boolean checkPassword(String username, char[] password) {
        System.out.println("PhysioManagerImpl is checking password");
        UserDAOIF userDAO = daoFactory.getUserDAO();
        if (userDAO.checkUserExistance(username)) {
            String hashedPassword = passwordManager.hashPassword(
                                        passwordManager.saltPassword(password, userDAO.getSalt(username))
                                                       .getBytes()
            );
            
            boolean passwordIsCorrect = userDAO.checkPassword(username, hashedPassword);
            System.out.println("PhysioManagerImpl returns: " + passwordIsCorrect + "\n");
            return passwordIsCorrect;
        }
        System.out.println("PhysioManagerImpl returns: false\n");
        return false;
    }
    
}
