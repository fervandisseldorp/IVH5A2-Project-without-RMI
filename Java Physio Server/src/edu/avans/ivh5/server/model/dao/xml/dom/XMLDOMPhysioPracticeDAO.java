/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.PhysioPracticeDAOIF;
import edu.avans.ivh5.shared.model.domain.PhysioPractice;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author Sjonn
 */
public class XMLDOMPhysioPracticeDAO implements PhysioPracticeDAOIF{
    private XmlDOMDocument domDocument;
    private Document document;
    private DateFormat format;
    private Format formatter;
    
    
    public XMLDOMPhysioPracticeDAO(){
        this.format = new SimpleDateFormat("yyyy-MM-dd");
        this.formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.domDocument = new XmlDOMDocument("C:\\Users\\ferdinand\\Documents\\GitHub\\IVH5\\IVH5A2-Project-zonder-RMI\\Java Physio Server\\resources\\physiopractice.xml", "C:\\Users\\ferdinand\\Documents\\GitHub\\IVH5\\IVH5A2-Project-zonder-RMI\\Java Physio Server\\resources\\physiopractice.xsd");
        this.document = domDocument.getDocument();
    }

    @Override
    public boolean savePhysioPractice(PhysioPractice physiopractice) {
        System.out.println("XMLDOMUserDAO is getting the obj:PhysioPractice");
        if (document != null) {
            NodeList list = document.getElementsByTagName("physiopractice"); //hier de naam van hetgene wat je zoekt

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    
                    //Format date to string for writing
                    String birthdate = format.format(physiopractice.getBirthdate());
                    
                    //Set data
                    child.setAttribute("naam", physiopractice.getNaam());
                    //child.setAttribute("lastname", physiopractice.getLastname());
                    child.setAttribute("employeeType", physiopractice.getEmployeeType());
                    child.setAttribute("birthdate", birthdate);
                    child.setAttribute("cellphoneNr", physiopractice.getCellphoneNr());
                    child.setAttribute("zipcode", physiopractice.getZipcode());
                    child.setAttribute("homeNr", physiopractice.getHomeNr());
                    child.setAttribute("city", physiopractice.getCity());
                    child.setAttribute("IBAN", physiopractice.getIBAN());
                    
                    this.domDocument.writeDocument();
                    return true;
                }
            }
        } else {
            System.out.println("XMLDOMUserDAO could not get the PhysioPractice due to a missing document");
        }
        System.out.println("XMLDOMUserDAO did not find the PhysioPractice");
        return false;
    }
    
    @Override
    public PhysioPractice getPhysioPractice() {
        System.out.println("XMLDOMUserDAO is getting the obj:PhysioPractice");
        if (document != null) {
            NodeList list = document.getElementsByTagName("physiopractice"); // hier de naam van hetgene wat je zoekt

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    String naam = child.getElementsByTagName("naam").item(0).getTextContent();
//                    String lastname = child.getElementsByTagName("lastname").item(0).getTextContent();
                    String employeeType = child.getElementsByTagName("employeeType").item(0).getTextContent();
                    String stringBirthdate = child.getElementsByTagName("StringBirthdate").item(0).getTextContent();
                    String cellphoneNr = child.getElementsByTagName("cellphoneNr").item(0).getTextContent();
                    String zipcode = child.getElementsByTagName("zipcode").item(0).getTextContent();
                    String homeNr = child.getElementsByTagName("homeNr").item(0).getTextContent();
                    String city = child.getElementsByTagName("city").item(0).getTextContent();
                    String IBAN = child.getElementsByTagName("IBAN").item(0).getTextContent();
                    
                    
                    Date birthDate = new Date();
                    try {
                        birthDate = format.parse(stringBirthdate);
                    } catch (ParseException ex) {
                        System.out.println("Failed to parse date");
                    }
                    return new PhysioPractice(naam, /*lastname,*/ employeeType, birthDate, cellphoneNr, zipcode, homeNr, city, IBAN);
                }
            }
        } else {
            System.out.println("XMLDOMUserDAO could not get the PhysioPractice due to a missing document");
        }
        System.out.println("XMLDOMUserDAO did not find the PhysioPractice");
        return null;
    }
}