<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>


<%
	ApplicationUser au = (ApplicationUser) session.getAttribute("user");
%>

<jsp:include page="header.jsp" />


<div style="margin:30px;">
<img src="img/profileImage.png" width="100" height="100">
<h3><%=au.getName()%> <%= au.getSurname() %></h3>


<h4>Your Information:</h4>

<table>
	<tr>
		<th>Email</th>
		<th>Address</th>
		<th>Name</th>
		<th>Surname</th>
	</tr>
	<tr>
		<td><%=au.getEmail()%></td>
		<td><%=au.getAddress()%></td>
		<td><%=au.getName()%></td>
		<td><%=au.getSurname()%></td>
</table>



<a href="editUser.html" style="padding:20px;">  Edit Information  </a>
<a href="deleteUser.html" style="padding:20px;">  Delete Account  </a>
</div>
<jsp:include page="footer.jsp" />