/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.util.Date;

/**
 *
 * @author Sjonn
 */
public class PhysioPractice {
    String naam;
//  String lastname;
    String employeeType;
    Date birthdate;
    String cellphoneNr;
    String zipcode;
    String homeNr;
    String city;
    String IBAN;
    
    public PhysioPractice(String naam, /*String lastname, */ String employeeType, Date birthdate, String cellphoneNr, String zipcode, String homeNr, String city, String IBAN){
        this.naam = naam;
//      this.lastname = lastname;
        this.employeeType = employeeType;
        this.birthdate = birthdate;
        this.cellphoneNr = cellphoneNr;
        this.zipcode = zipcode;
        this.homeNr = homeNr;
        this.city = city;
        this.IBAN = IBAN;   
    }
    
    public PhysioPractice(){}
    
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

/*
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
*/
    
    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCellphoneNr() {
        return cellphoneNr;
    }

    public void setCellphoneNr(String cellphoneNr) {
        this.cellphoneNr = cellphoneNr;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getHomeNr() {
        return homeNr;
    }

    public void setHomeNr(String homeNr) {
        this.homeNr = homeNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
}