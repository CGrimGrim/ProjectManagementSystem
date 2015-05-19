package dwp.resource.management.servlet;

import dwp.resource.management.data.DataLink;
import dwp.resource.management.objects.Employee;
import dwp.resource.management.objects.Project;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProjectController extends HttpServlet {
	
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
           int projectID = Integer.parseInt(req.getParameter("projectID"));
           int hours = Integer.parseInt(req.getParameter("totalHours"));
           Project p = new Project(projectID,req.getParameter("name"),
                                     hours, req.getParameter("locationID"),
                                     req.getParameter("phase"),startDate, endDate);
           dl.addProject(p);
           req.setAttribute("successful", true);
           req.getRequestDispatcher("newProject.jsp").forward(req,res);
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

