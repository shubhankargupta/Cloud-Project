/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ejb.EJBException;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

/**
 *
 * @author Gupta
 */
@Stateful
public class DoctorBean implements SimpleDoctor,SessionBean {
    String dis;
    String sym;
    String cures;

    
    
    @Override
    public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Hello");
    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ejbActivate() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EJBHome getEJBHome() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getPrimaryKey() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove() throws RemoteException, RemoveException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Handle getHandle() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isIdentical(EJBObject obj) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String addData(String symptom, String disease, String cure,String doctor_id) {
         int flag=0;
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospital","root","root");
        
        //Statement s=conn.createStatement();
        
        //ResultSet rs=s.executeQuery("select username,password,name from patient");
        
        PreparedStatement ps=conn.prepareStatement("insert into remedy_catalog values(?,?,?,?)");
        
        
        ps.setString(1,symptom);
        ps.setString(2,disease);
        ps.setString(3,cure);
        ps.setString(4,doctor_id);
        
        int x=ps.executeUpdate();
        
        if(x>=1)
        {
            flag=1;
        }
        
                
        }
        
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
            
        }
        
        String message="The data has been added successfully";
        
        if(flag==1)
        {   return message;
        }
        
        else{
            return "Sorry could not enter the data";
        }
        
    }
}
