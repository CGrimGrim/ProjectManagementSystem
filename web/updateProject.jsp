<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dwp.resource.management.objects.Project"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Staff</title>
<link rel="stylesheet" type = "text/css" href="projectManagement.css">
<link rel="stylesheet" type = "text/css" href="dropDown.css">
</head>
<body>
<header>
<h2>Update Staff</h2>
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
		<li><form class="dropDown" action="deleteStaff.jsp">
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
<table class="tablestyle">
<tr>
	<th>Project ID</th>
	<th>Project Name</th>
	<th>Total Hours Per Week</th>
	<th>Location</th>
	<th>Phase</th>
	<th>Start Date</th>
	<th>End Date</th>
</tr>
<%
    if(request.getAttribute("projectToUpdate") == null){
        out.println("<tr><td colspan=7>No project found</td></tr>");
    }
    else{
        Project p = (Project)request.getAttribute("projectToUpdate");
        ArrayList<Location> locations = (ArrayList<Location>)request.getAttribute("locations");
        String locationDropDown = "<select>";
        for(Location l : locations){
            locationDropDown += "<option value="+l.getId()+">"+l.getName()+"</option>";
        }
        locationDropDown += "</select>";
        out.println("<tr>"
                +"<td></td>"  //projectID
                +"<td></td>"  //Project Name
                +"<td></td>"  //Total hours
                +"<td>"+locationDropDown+"</td>"  //Location
                +"<td></td>"  // Phase
                +"<td></td>"  // Start date
                +"<td></td>"  // End date
                +"</tr>");
    }
%>
</table>
<br>
<br>
<br>
<button onClick="location.href='index.jsp'">Back To Home Page</button>
</body>
</html>