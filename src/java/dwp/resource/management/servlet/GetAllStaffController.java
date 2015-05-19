package dwp.resource.management.servlet;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dwp.resource.management.data.DataLink;
import dwp.resource.management.objects.Employee;

public class GetAllStaffController extends HttpServlet {
	
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
            ResultSet rs = dl.getAllStaff();
            List<Employee> allStaff = new ArrayList<Employee>();
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while (rs.next()){
                LocalDate startDate = LocalDate.parse(rs.getString(4), dt);
                LocalDate endDate = LocalDate.parse(rs.getString(5), dt);
                int empID = Integer.parseInt(rs.getString(1));
                double hours = Double.parseDouble(rs.getString(8));
                Employee e = new Employee(empID,req.getParameter("fname"),
                                          req.getParameter("lname"),
                                          startDate, endDate,
                                          req.getParameter("contact_num"),
                                          req.getParameter("contract_type"), hours);
                allStaff.add(e);
            }
            req.setAttribute("Results", allStaff);
            req.getRequestDispatcher("allStaff.jsp").forward(req,res);
            }
        catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Exception: " + e.getStackTrace()[0]);
        }
    }
    
    @Override
    public void destroy(){
        
    }

}
