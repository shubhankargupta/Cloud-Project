/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.EJBObject;
import javax.ejb.Local;

/**
 *
 * @author Gupta
 */
@Local
public interface SimplePatient extends EJBObject{
    
    
    
    public String getDisease(String symptom);
    
    public String getBloodInfo(String blood);
    
    
    
    
    
    
}
