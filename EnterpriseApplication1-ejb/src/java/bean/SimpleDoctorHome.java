/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Local;
import javax.ejb.EJBHome;
import javax.ejb.CreateException;

/**
 *
 * @author Gupta
 */
@Local
public interface SimpleDoctorHome extends EJBHome {
    
    public SimpleDoctor create() throws CreateException;
    
}
