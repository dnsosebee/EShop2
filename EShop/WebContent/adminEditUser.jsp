<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="adminEditUsers.html">All Users</a></li>
				<li class="active">Edit User</li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<div style="margin:30px;">

<h1>Edit User</h1>

<%
	es.uc3m.eshop.model.ApplicationUser au = (es.uc3m.eshop.model.ApplicationUser) session.getAttribute("userToEdit");
%>


<form method = "post" action = "editUser.html">
<input type = "hidden" name = "userChanges" value = "<%= au.getEmail()%>">

	
	First Name:<input type = "text" name = "newName" required value = "<%=au.getName() %>"></input>
	<br>
	Last Name:<input type = "text" name = "newSurname" required value = "<%= au.getSurname() %>"></input>
	<br>
	Password:<input type = "text" name = "newPassword" required value = "<%= au.getPassword() %>"></input>
	<br>
	Address:<input type = "text" name = "newAddress" required value = "<%= au.getAddress() %>"></input>
	<br>
	<br>
	Type of User:
	<input type="radio" name="role" value="0" <%=(au.getRole() == 0) ? "checked='checked'" : 0 %>> Shopper 
	<input type="radio" name="role" value="1" <%=(au.getRole() == 1) ? "checked='checked'" : 0 %>> Seller 
	<input type="radio" name="role" value="2" <%=(au.getRole() == 2) ? "checked='checked'" : 0 %>> Admin 
	<br>
	<br>
	<input type = "submit" value = "Submit Changes">

</form>

</div>

<jsp:include page="footer.jsp"/>