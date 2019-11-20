<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>



<jsp:include page="header.jsp" />

<div style="margin:30px;">

<h3>Admin Panel</h3>
<%-- 
<jsp:useBean id="users" scope="request"
	class="java.util.ArrayList<es.uc3m.eshop.model.ApplicationUser>" />
 --%>

<h3>Edit Users</h3>

<table>
	<tr>
		<th>Email</th>
		<th>Address</th>
		<th>Name</th>
		<th>Surname</th>
		<th>Edit User</th>
		<th>Delete User</th>
	</tr>
	
	<% List<ApplicationUser> allUsers = (List<ApplicationUser>) request.getAttribute("allUsers"); %>
	<% for(ApplicationUser user: allUsers) {%>
	<tr>
		<td><%=user.getEmail()%></td>
		<td><%=user.getAddress()%></td>
		<td><%=user.getName()%></td>
		<td><%=user.getSurname()%></td>
		<td>
		<form method = "post" action = "editUser.html">
		<input type = "submit" value = "Edit User"/>
		<input type="hidden" name="editUserEmail" value="<%=user.getEmail()%>" />
			
		</form>
		</td>
		<td>
		<form method = "post" action = "adminDeleteUser.html">
		<input type = "submit" value = "Delete User">
		<input type = "hidden" name = "adminDeleteUser" value ="<%=user.getEmail() %>">
		</form>
	</tr>
	
	
	<%} %>
</table>


</div>

<jsp:include page="footer.jsp" />
