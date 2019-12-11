<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>


<%
	es.uc3m.ctw.model.Applicationuser au = (es.uc3m.ctw.model.Applicationuser) session.getAttribute("user");
%>

<jsp:include page="header.jsp" />

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<div style="margin:30px;">

<h2>Seller Homepage</h2>
<br>
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

<br>
<h3>Account Management</h3>
<a href="editUser.html" style="padding:20px;">  Edit Information  </a>
<a href="deleteUser.html" style="padding:20px;">  Delete Account  </a>
<br>
<br>
<h3>Product Management</h3>
<a href = "addProduct.html" style="padding:20px;">  Add Product  </a>
<a href = "editSellerProducts.html" style="padding:20px;">  View and Edit Products  </a>
<br>
<br>
<h3>Messaging</h3>
<form action="message.html" method="POST" >

<input type="hidden" name="allUsers" value=" " />

<input type="submit" value="Send a message to all shoppers">

</form>
</div>
<jsp:include page="footer.jsp" />