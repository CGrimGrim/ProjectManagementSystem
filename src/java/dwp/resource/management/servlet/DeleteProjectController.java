/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwp.resource.management.servlet;

import dwp.resource.management.data.DataLink;
import dwp.resource.management.objects.User;
import java.sql.ResultSet;
import java.time.format.*;
import java.time.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import dwp.resource.management.objects.*;

/**
 *
 * @author 10071639
 */
public class DeleteProjectController extends HttpServlet {
    
    DataLink dl = null;
    
     @Override
     public void init(ServletConfig sc) throws ServletException{
         try{
             dl = new DataLink(sc.getInitParameter("connectionString"), sc.getInitParameter("username"), sc.getInitParameter("password"));
         }
         catch(Exception e){
             System.out.println("Exception: " + e.getMessage());
         }
         
     }
     
     @Override
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException{
         try{
             String reqParameter = req.getParameter("staffID");
             int employeeID = Integer.parseInt(reqParameter);
             ResultSet rs = dl.getEmployee(employeeID);
             if(!rs.isBeforeFirst()){
                 req.setAttribute("result", false);
             }
             else{
                 rs.next();
                 LocalDate startDate = rs.getDate(4).toLocalDate();
                 LocalDate endDate = rs.getDate(5).toLocalDate();
                 Employee employeeToDelete = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), startDate, endDate, rs.getString(6), rs.getString(7), rs.getDouble(8));
                 req.setAttribute("employeeToDelete", employeeToDelete);
             }
             
             req.getRequestDispatcher("deleteStaff.jsp").forward(req,res);
         }
         catch(Exception e){
             System.out.println("Exception: " + e.getMessage());
             System.out.println("Exception: " + e.getStackTrace()[0]);
         }
     }
     
     @Override
     public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
         try{
            String e = req.getParameter("staffID");
            dl.deleteEmployee(e);
            req.setAttribute("successful", true);
            req.getRequestDispatcher("deleteStaff.jsp").forward(req,res);
            
        }
        catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Exception: " + e.getStackTrace()[0] + e.getStackTrace()[1]);
        }
     }
     
     @Override
     public void destroy(){
         
     }
}
