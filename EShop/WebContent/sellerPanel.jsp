<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>


<%
	ApplicationUser au = (ApplicationUser) session.getAttribute("user");
%>

<jsp:include page="header.jsp" />



<img src="img/profileImage.png" width="100" height="100">
<h3><%=au.getName()%></h3>


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

<br>
<h3>Account Management</h3>
<a href="editUser.html">Edit Information</a>
<a href="deleteUser.html">Delete Account</a>
<br>
<h3>Product Management</h3>
<a href = "addProduct.html">Add Product</a>
<a href = "editSellerProducts.html">View and Edit Products</a>

<jsp:include page="footer.jsp" />