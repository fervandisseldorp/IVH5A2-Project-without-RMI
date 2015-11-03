/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.EmployeeDAOIF;
import edu.avans.ivh5.shared.model.domain.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author bernd_000
 */
public class XMLDOMEmployeeDAO implements EmployeeDAOIF {

    private XmlDOMDocument domDocument = null;
    private Document document = null;

    public XMLDOMEmployeeDAO() {
        this.domDocument = new XmlDOMDocument("C:\\Users\\ferdinand\\Documents\\GitHub\\IVH5\\IVH5A2-Project-zonder-RMI\\Java Physio Server\\resources\\employees.xml", "C:\\Users\\ferdinand\\Documents\\GitHub\\IVH5\\IVH5A2-Project-zonder-RMI\\Java Physio Server\\resources\\employees.xsd");
        this.document = domDocument.getDocument();
    }
    
    @Override
    public boolean saveEmployee(Employee newEmployee) {
        System.out.println("XMLDOMEmployeeDAO save ");

        // vind root element employees
        Node rootElement = document.getElementsByTagName("employees").item(0);
        // maak nieuwe lege employee en voeg deze toe aan employees
        Element employee = document.createElement("employee");
        rootElement.appendChild(employee);

        // voeg data toe
        Element id = document.createElement("id");
        id.appendChild(document.createTextNode(newEmployee.getID()));
        employee.appendChild(id);

        Element firstname = document.createElement("firstname");
        firstname.appendChild(document.createTextNode(newEmployee.getFirstname()));
        employee.appendChild(firstname);

        Element lastname = document.createElement("lastname");
        lastname.appendChild(document.createTextNode(newEmployee.getLastname()));
        employee.appendChild(lastname);

        Element phoneNr = document.createElement("phoneNr");
        phoneNr.appendChild(document.createTextNode(newEmployee.getPhoneNr()));
        employee.appendChild(phoneNr);

        Element email = document.createElement("email");
        email.appendChild(document.createTextNode(newEmployee.getEmail()));
        employee.appendChild(firstname);

        domDocument.writeDocument();
        return true;
    }

    @Override
    public boolean alterEmployee(Employee employee) {
        System.out.println("XMLDOMUserDAO is altering the employee");
        if (document != null) {
            NodeList list = document.getElementsByTagName("employees"); // hier de naam van hetgene wat je zoekt

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if (child.getElementsByTagName("id").item(0).getTextContent().equalsIgnoreCase(employee.getID())) {
                        System.out.println("found " + employee.getLastname());
                        child.getElementsByTagName("id").item(0).setTextContent(employee.getID());
                        child.getElementsByTagName("firstname").item(0).setTextContent(employee.getFirstname());
                        child.getElementsByTagName("lastname").item(0).setTextContent(employee.getLastname());
                        child.getElementsByTagName("phoneNr").item(0).setTextContent(employee.getPhoneNr());
                        child.getElementsByTagName("email").item(0).setTextContent(employee.getEmail());

                        domDocument.writeDocument();

                        return true;
                    }
                }
            }
        } else {
            System.out.println("XMLDOMEmployeeDAO could not get the employee due to a missing document");
        }
        System.out.println("XMLDOMEmployeeDAO did not find the employee");
        return false;
    }

    @Override
    public Employee getEmployee(String name) {
        System.out.println("XMLDOMUserDAO is getting the employee");
        if (document != null) {
            NodeList list = document.getElementsByTagName("employee");
            
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if (child.getElementsByTagName("lastname").item(0).getTextContent().equals(name)) {
                        String id = child.getElementsByTagName("id").item(0).getTextContent();
                        String firstname = child.getElementsByTagName("firstname").item(0).getTextContent();
                        String lastname = child.getElementsByTagName("lastname").item(0).getTextContent();
                        String phoneNr = child.getElementsByTagName("phoneNr").item(0).getTextContent();
                        String email = child.getElementsByTagName("email").item(0).getTextContent();
                        return new Employee(id, firstname, lastname, phoneNr, email);
                    }
                }
            }
        } 
        return null;
    }
            
    @Override
    public boolean deleteEmployee(String employeeID) {

        System.out.println("XMLDOMUserDAO is deleting the employee");
        if (document != null) {
            NodeList list = document.getElementsByTagName("employee");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if (child.getElementsByTagName("id").item(0).getTextContent().equalsIgnoreCase(employeeID)) {
                        child.getParentNode().removeChild(node);
                        domDocument.writeDocument();

                        return true;
                    }
                }
            }
        } else {
            System.out.println("XMLDOMUserDAO could not get the employee due to a missing document");
        }
        System.out.println("XMLDOMUserDAO did not find the employee");
        return false;
    }

}
