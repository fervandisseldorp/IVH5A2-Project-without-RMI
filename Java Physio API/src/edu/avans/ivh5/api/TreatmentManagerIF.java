/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.api;

import edu.avans.ivh5.shared.model.domain.ClientDTO;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.util.ArrayList;

/**
 *
 * @author bernd_000
 */
public interface TreatmentManagerIF {
    public Employee getTherapist(String name);
    
    public boolean saveTreatment(Treatment treatment);
    
    public boolean alterTreatment(Treatment treatment);
    
    public boolean deleteTreatment(Treatment treatment);
    
    public boolean saveSession(Session session);
    
    public boolean alterSession(Session session);
    
    public boolean deleteSession(Session session);
    
    public ClientDTO getClient();
    
    public ArrayList<Treatment> getTreatmentsByTherapistID(int therapistID);
    
    public String getBSNBySession(int sessionID);
    
    public Employee getTherapistBySession(int sessionID);
    
    public Treatment getTreatmentBySession(int sessionID);
    
    public Treatment getTreatmentByID(int treatmentID);
}
