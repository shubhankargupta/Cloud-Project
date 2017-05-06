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
public interface SimpleSession extends EJBObject{
    
    public String validatePatient(String username,String password);
    
    public String validateDoctor(String username,String password);
    
    public String getDoctorId();
    
    
}
