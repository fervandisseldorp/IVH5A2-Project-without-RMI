/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferdinand
 */
public class Employee2 {
    private int ID;
    private String firstname;
    private String lastname;
    private String phoneNr;
    private String email;
    
    public Employee2(int ID, String firstname, String lastname, String phoneNr, String email){
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNr = phoneNr;
        this.email = email;
        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
