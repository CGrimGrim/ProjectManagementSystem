/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwp.resource.management.servlet;

/**
 *
 * @author 10071639
 */

import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import dwp.resource.management.data.*;
import dwp.resource.management.objects.*;


public class AuthorisationController extends HttpServlet{
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
             ResultSet rs = dl.getUserInformation(req.getParameter("username"));
             if(!rs.isBeforeFirst()){
                 req.setAttribute("authenticated", false);
             }
            
             else{
                 rs.next();
                 User currentUserObj = null;
                 if(rs.getString(3).equals(req.getParameter("password"))){
                   currentUserObj = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5), rs.getBoolean(6));
                    HttpSession session = req.getSession(true);
                    session.setAttribute("currentUser", currentUserObj);
                    res.sendRedirect("index.jsp");
                    return;
                 }
                 else{
                     req.setAttribute("authenticated", false);
                 }
             }
             
             req.getRequestDispatcher("logIn.jsp").forward(req,res);
         }
         catch(Exception e){
             System.out.println("Exception: " + e.getMessage());
             e.printStackTrace();
         }
     }
     
     @Override
     public void destroy(){
         
     }
}
