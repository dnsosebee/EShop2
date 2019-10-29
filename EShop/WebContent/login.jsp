<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>


<form action="login.html" method="POST" >

<label>Email: <input type="email" required name="email"></label>
<br>

<label>Password: <input type="password" required name="password"></label>
<br>

<input type="submit" value="Sign up">

</form>

<% if (request.getAttribute("hasFailed") != null) { %>
	<p style="color:red;">The email and password entered did not match an account. Please try again.</p>
<% } %>

<jsp:include page="footer.jsp"/>