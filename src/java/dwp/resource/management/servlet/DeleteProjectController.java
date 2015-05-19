/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwp.resource.management.servlet;

import dwp.resource.management.data.DataLink;
import java.sql.ResultSet;
import java.time.format.*;
import java.time.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import dwp.resource.management.objects.*;
import java.io.IOException;
import java.sql.SQLException;

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
             String reqParameter = req.getParameter("projectID");
             int projectID = Integer.parseInt(reqParameter);
             ResultSet rs = dl.getProject(projectID);
             if(!rs.isBeforeFirst()){
                 req.setAttribute("result", false);
             }
             else{
                 rs.next();
                 Project projectToDelete = new Project(projectID, rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate());
                 req.setAttribute("projectToDelete", projectToDelete); 
             }
             req.getRequestDispatcher("deleteProject.jsp").forward(req,res);
         }
         catch(Exception e){
             System.out.println("Exception: " + e.getMessage());
             System.out.println("Exception: " + e.getStackTrace()[0]);
             System.out.println("Exception: " + e.getStackTrace()[1]);
         }
     }
     
     @Override
     public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         try{
            int e = Integer.parseInt(req.getParameter("projectID"));
            dl.deleteProject(e);
            req.setAttribute("successful", true);
            req.getRequestDispatcher("deleteProject.jsp").forward(req,res);
            
        }
        catch(SQLException e){
            int errorCode  = e.getErrorCode();
            if(errorCode == 547){
                req.setAttribute("successful", false);
                req.setAttribute("Error Msg", "Cannot delete project that has staff assigned to it");
                req.getRequestDispatcher("deleteProject.jsp").forward(req,res);
            }
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
