/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.EJBException;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import javax.ejb.Stateless;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 *
 * @author Gupta
 */
@Stateless
public class LoginBean implements SimpleSession,SessionBean {

    String dname;
    String symp;
    String disease;
    String cure;
    String doctor_id;
    String did;
    String name;
    String pname;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public String validatePatient(String username,String password)
    {
        int flag=0;
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospital","root","root");
        
        Statement s=conn.createStatement();
        
        ResultSet rs=s.executeQuery("select username,password,name from patient");
        
        while(rs.next())
        {
            String fname = rs.getString("username");
            String pass=rs.getString("password");
            dname=rs.getString("name");
            
            if(username.equals(fname) && password.equals(pass))
            {
                flag=1;
                break;
            }
                
        }        
        }
        
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
            
        }
        
        String message="WELCOME "+dname;
        
        if(flag==1)
        {   return message;
        }
        
        else{
            return "Either Username or Password is wrong";
        }
        

        
    }
    
    
    @Override
    public String validateDoctor(String username,String password)
    {
        int flag=0;
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospital","root","root");
        
        Statement s=conn.createStatement();
        
        ResultSet rs=s.executeQuery("select username,password,name,license_id from doctor");
        
        while(rs.next())
        {
            String fname = rs.getString("username");
            String pass=rs.getString("password");
            pname=rs.getString("name");
            doctor_id=rs.getString("license_id");
            
            if(username.equals(fname) && password.equals(pass))
            {
                flag=1;
                break;
            }
                
        }        
        }
        
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
            
        }
        
        String message="WELCOME "+pname.toUpperCase();
        
        if(flag==1)
        {   return message;
        }
        
        else{
            return "Either Username or Password is wrong";
        }
        

        
    }
    
    
    @Override
    
    public String getDoctorId()
    {
        return doctor_id;
    }
    
    
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
    
}
