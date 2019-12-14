<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li class="active">Edit User Profile</li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<div style="margin:30px;">

<h1>Edit User Profile</h1>

<%
	es.uc3m.eshop.model.ApplicationUser au = (es.uc3m.eshop.model.ApplicationUser) session.getAttribute("user");
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
	
	<input type = "submit" value = "Submit Changes">


</form>

</div>

<jsp:include page="footer.jsp"/>