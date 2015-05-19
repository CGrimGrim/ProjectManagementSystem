/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwp.resource.management.data;

/**
 *
 * @author 10071639
 */
import dwp.resource.management.objects.*;

import java.sql.*;

public class DataLink {
    
    private Connection connect = null;
    private CallableStatement callstat = null;
    private Statement statement = null;
    
    public DataLink(String databaseLocation, String username, String password) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection(databaseLocation, username, password);
        statement = connect.createStatement();
        
    }
    
      
    public void addProject(Project p) throws SQLException {
    	callstat = connect.prepareCall("call addProject(?,?,?,?,?,?,?)");
    	callstat.setInt(1, p.getProjectID());
    	callstat.setString(2, p.getName());
    	callstat.setInt(3, p.getTotalHours());
    	callstat.setString(4, p.getLocationID());
    	callstat.setString(5, p.getPhase());
    	callstat.setDate(6, Date.valueOf(p.getStartDate()));
    	callstat.setDate(7, Date.valueOf(p.getEndDate()));
        callstat.execute();
    }
           
    public void deleteEmployee(String id) throws SQLException{
       callstat = connect.prepareCall("Call deleteEmployee(?)");        
        callstat.setString(1, id );
        callstat.execute(); 
    }
    
    public void addEmployee(Employee e) throws SQLException{
        callstat = connect.prepareCall("call addEmployee(?,?,?,?,?,?,?,?)");
        callstat.setInt(1, e.getEmployeeID());
        callstat.setString(2, e.getFirstName());
        callstat.setString(3, e.getLastName());
        callstat.setDate(4, Date.valueOf(e.getStartDate()));
        callstat.setDate(5, Date.valueOf(e.getEndDate()));
        callstat.setString(6, e.getContactNumber());
        callstat.setString(7, e.getContractType());
        callstat.setDouble(8, e.getContractedHours());
        callstat.executeQuery();
    }
    
    public void updateEmployee(Employee e) throws SQLException{
        callstat = connect.prepareCall("call updateEmployee(?,?,?,?,?,?,?,?)");
        callstat.setInt(1, e.getEmployeeID());
        callstat.setString(2, e.getFirstName());
        callstat.setString(3, e.getLastName());
        callstat.setDate(4, Date.valueOf(e.getStartDate()));
        callstat.setDate(5, Date.valueOf(e.getEndDate()));
        callstat.setString(6, e.getContactNumber());
        callstat.setString(7, e.getContractType());
        callstat.setDouble(8, e.getContractedHours());
        callstat.executeQuery();
        
    }
    
    public ResultSet getUserInformation(String username) throws SQLException{
        callstat = connect.prepareCall("call retrieveUserInformation(?)");
        callstat.setString(1, username);
        return callstat.executeQuery();
    }
    
    public ResultSet getEmployee(int employeeID) throws SQLException{
        callstat = connect.prepareCall("call searchEmployeeByID(?)");
        callstat.setInt(1, employeeID);
        return callstat.executeQuery();
    }
    
    public ResusltSet getAllStaff() throws SQLException{
    	ResultSet rs = statement.executeQuery("SELECT * from employee");
    	return rs;
    }
    
    public void deleteProject(int projectID) throws SQLException{
        callstat = connect.prepareCall("call deleteProject(?)");
        callstat.setInt(1, projectID);
        callstat.execute();
    }
}