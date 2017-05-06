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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class PatientBean implements SimplePatient,SessionBean {

    String dname;
    String symp;
    String disease;
    String cure;
    String doctor_id;
    String did;
    String name;
    String bloodbank;
    String bloodgroup;
    String location;
    int quantity;
    String message4;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    @Override
    public String getDisease(String symptom)
    {
        int flag1=0;
        int flag2=0;
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","test")) {
                Statement s1=con.createStatement();
                Statement s2=con.createStatement();
                
                ResultSet rs1=s1.executeQuery("select symptom,disease,cure,doctor_id from remedy_catalog");
                ResultSet rs2=s2.executeQuery("select name,license_id from doctor");
                
                while(rs1.next())
                {
                    symp=rs1.getString("symptom");
                    disease = rs1.getString("disease");
                    cure=rs1.getString("cure");
                    doctor_id=rs1.getString("doctor_id");
                    
                    System.out.println(symp+" "+symptom);
                    
                    if(symp.equalsIgnoreCase(symptom))
                    {
                        flag1=1;
                        break;
                    }
                    
                }
                
                while(rs2.next())
                {
                    did=rs2.getString("license_id");
                    name=rs2.getString("name");
                    
                    if(did.equals(doctor_id))
                    {
                        flag2=1;
                        break;
                    }
                    
                }   }
               
        }
        
        
        
        
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
            
        }
        
        String message2;
        message2 = "The disease might be "+disease+" and the cure for this disease is:- "+cure+System.lineSeparator()+ ". You may contact "+ name+" for futher queries.";
        
        
        if(flag1==1 && flag2==1)
        {   return message2;
        }
        
        else{
            return "Either Username or Password is wrong "+flag1+" "+flag2;
        }
        
        
        
        
    }
    
    
    
    @Override
    public String getBloodInfo(String blood)
    {
        int flag4=0;
        int flag5=0;
        
        try{
             Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","test")) {
                   
                Statement st3=conn.createStatement();
                Statement st4=conn.createStatement();
                PreparedStatement ps=conn.prepareStatement("update bloodbank_catalog set quantity=? where blood_group=? ");
                
                
                ResultSet rs3=st3.executeQuery("select name,blood_group from bloodbank");
                ResultSet rs4=st4.executeQuery("select blood_group,quantity,location from bloodbank_catalog");
                
                while(rs3.next())
                {
                    bloodbank=rs3.getString("name");
                    bloodgroup=rs3.getString("blood_group");
                    
                    if(bloodgroup.equalsIgnoreCase(blood))
                    {
                        flag4=1;
                        break;
                    }                    
                    
                    
                }
                
                while(rs4.next())
                {
                 
                    if(rs4.getString("blood_group").equalsIgnoreCase(bloodgroup))
                    {
                        location=rs4.getString("location");
                        quantity=rs4.getInt("quantity");
                        flag5=1;
                        break;
                    }
                    
                }
                
                if(flag4==1 && flag5==1)
                {ps.setInt(1,quantity-1);
                ps.setString(2,bloodgroup);
                
                ps.executeUpdate();
                
                message4=quantity+" bottles of BLOODGROUP "+bloodgroup+" is available at "+bloodbank+" which is located at "+location;
                }
            }
            
        }
        
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    
        
        return message4;
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
