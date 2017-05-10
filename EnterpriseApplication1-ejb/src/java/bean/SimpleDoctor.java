/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Local;

/**
 *
 * @author Gupta
 */
@Local
public interface SimpleDoctor extends EJBObject {
    
    public String addData(String symptom,String disease,String cure,String doctor_id);

    public EJBHome getEJBHome() throws RemoteException;
    
}

