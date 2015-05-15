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
public class AddEmployeeController extends HttpServlet {
    
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
     public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
        try{
            
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.parse(req.getParameter("start_date"), dt);
            LocalDate endDate = LocalDate.parse(req.getParameter("end_date"), dt);
            int empID = Integer.parseInt(req.getParameter("staffID"));
            double hours = Double.parseDouble(req.getParameter("contract_hours"));
            Employee e = new Employee(empID,req.getParameter("fname"),
                                      req.getParameter("lname"),
                                      startDate, endDate,
                                      req.getParameter("contact_num"),
                                      req.getParameter("contract_type"), hours);
            dl.addEmployee(e);
            req.setAttribute("successful", true);
            req.getRequestDispatcher("newStaff.jsp").forward(req,res);
            
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
