<%@page import="dwp.resource.management.objects.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Staff</title>
<link rel="stylesheet" type = "text/css" href="projectManagement.css">
<link rel="stylesheet" type = "text/css" href="dropDown.css">
</head>
<body>
<header>
<h2>Remove Staff</h2>
</header>
<nav class="menu">
<ul>

<li><a href="#">Staff</a>

	<ul>
	
	<li><a href="allStaff.jsp">View All Staff Members</a></li>
	
	<li><a href="">Update Staff Members Details</a>
		<ul>
		<li><form class="dropDown" action="updateStaff.jsp">
		Please Enter The Staff ID:
		<input type="text" name="staffID">
		<input type="submit" value="Submit">
		<br>
		<br>
		</form></li>
		</ul></li>

	<li><a href="assignStaff.jsp">Assign Employee To Project</a></li>
	
	<li><a href="unassignStaff.jsp">Un-assign Employee</a></li>
	
	<li><a href="newStaff.jsp">Add New Member Of Staff</a></li>
	
	<li><a href="">Remove Member Of Staff</a>
		<ul>
		<li><form class="dropDown" action="deleteStaff.jsp" method="get">
		Please Enter The Staff ID:
		<input type="text" name="staffID">
		<input type="submit" value="Submit">
		<br>
		<br>
		</form></li>
		</ul></li>
	</ul>	
</li>


<li><a href="#">Projects</a>
	<ul>
	<li><a href="#">Update A Project</a>
	<ul>
		<li><form class="dropDown" action="updateProject.jsp">
		Please Enter The Project ID:
		<input type="text" name="projectID">
		<input type="submit" value="Submit">
		<br>
		<br>
		</form></li>
		</ul></li>
	<li><a href="newProject.jsp">Add New Project</a></li>
	<li><a href="">Delete A Project</a>
	<ul>
		<li><form class="dropDown" action="deleteProject.jsp">
		Please Enter The Project ID:
		<input type="text" name="projectID">
		<input type="submit" value="Submit">
		<br>
		<br>
		</form></li>
		</ul></li>
	</ul>
</li>


<li><a href="#">Account</a>

	<ul>
	<li><a href="">My Account</a></li>
	<li><a href="">Change Password</a></li>
	<li><a href="logIn.jsp">Log Out</a></li>
	</ul>
</li>

<li><form action="#">
	Search:&nbsp;<select><option value="staff">Staff</option>
						 <option value="projects">Projects</option>
				 </select>
	By:&nbsp;<select><option value="staffID">Staff ID</option>
					 <option value="projectID">Project ID</option>
					 <option value="name">Name</option>
					 <option value="location">Location</option>
			 </select>
	&nbsp;&nbsp;<input type="search" name="id">
	<input type="submit" value="Submit">
	</form></li>
</ul>
</nav>
<br>
<br>
<form action="deleteEmployee" method="Post">
<table class="RemoveTablestyle">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Contracted Hours</th>
    <th>Start date</th>
    <th>End date</th>
    </thead>
    <tbody>
        <%
            if(request.getAttribute("employeeToDelete") == null){
               out.println("<tr><td colspan=5>No employee found</td></tr>");
            }
            else{
                Employee e = (Employee)request.getAttribute("employeeToDelete");
                out.println("<tr>"
                        + "<td>" + e.getEmployeeID() + "</td>"
                        + "<td>" + e.getFirstName() + " " + e.getLastName() + "</td>"
                        + "<td>" + e.getContractedHours() + "</td>"
                        + "<td>" + e.getStartDate() + "</td>"
                        + "<td>" + e.getEndDate() + "</td>"
                        + "</tr>");
             out.println("<input type=hidden value="+e.getEmployeeID()+" name=staffID");
            }
           
    %>
    </tbody>
</table>
    <input type="submit" value="Delete">
</form>
<br>
<br>
<br>
<button onClick="location.href='index.jsp'">Back To Home Page</button>
</body>
</html>