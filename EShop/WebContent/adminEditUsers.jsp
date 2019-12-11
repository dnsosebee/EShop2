<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>



<jsp:include page="header.jsp" />

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li class="active">All Users</li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<div style="margin:30px;">

<h3>Edit Users</h3>

<table>
	<tr>
		<th>Email</th>
		<th>Address</th>
		<th>Name</th>
		<th>Surname</th>
		<th>Type</th>
		<th>Edit User</th>
		<th>Delete User</th>
	</tr>
	
	<%
			List<es.uc3m.ctw.model.Applicationuser> allUsers = (List<es.uc3m.ctw.model.Applicationuser>) request.getAttribute("allUsers");
		%>
	<%
		for(es.uc3m.ctw.model.Applicationuser user: allUsers) {
	%>
	<tr>
		<td><%=user.getEmail()%></td>
		<td><%=user.getAddress()%></td>
		<td><%=user.getName()%></td>
		<td><%=user.getSurname()%></td>
		<td>
		<% if (user.getRole() == 2) { %>
		Admin
		<% } else if (user.getRole() == 1) { %>
		Seller
		<% } else { %>
		Shopper
		<% } %>
		</td>
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
