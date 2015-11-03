/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.TreatmentDAOIF;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author bernd_000
 */
public class XMLDOMTreatmentDAO implements TreatmentDAOIF {
    
    private XmlDOMDocument domDocument = null;
    private Document document = null;

    public XMLDOMTreatmentDAO() {
        this.domDocument = new XmlDOMDocument("C:\\Users\\ferdinand\\Documents\\Repositories\\VH5map\\IVH5A2-Project-zonder-RMI\\Java Physio Server\\resources\\treatmentsandsessions.xml", "C:\\Users\\ferdinand\\Documents\\Repositories\\VH5map\\IVH5A2-Project-zonder-RMI\\Java Physio Server\\resources\\treatmentsandsessions.xsd");
        this.document = domDocument.getDocument();
        
    }

    @Override
    public ArrayList getTreatments() {
        System.out.println("XMLDOMTreatmentDAO save ");
        
        ArrayList treatments = new ArrayList<Treatment>();
        
        return treatments;
    }
    

    @Override
    public Boolean saveTreatment(Treatment newTreatment) {
        Boolean succesful = true; // Create a check later
        
        Node rootElement = document.getElementsByTagName("treatments").item(0);
        // maak nieuwe lege employee en voeg deze toe aan employees
        Element treatment = document.createElement("treatment");
        rootElement.appendChild(treatment);
        
        
        return succesful;
    }

    @Override
    public boolean alterTreatment() {
        Boolean succesful = true; // Create a check later
        
        return succesful;
    }

    @Override
    public boolean deleteTreatment() {
        Boolean succesful = true; // Create a check later
        
        return succesful;
    }
    
}
