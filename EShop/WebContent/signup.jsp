<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>

<form action="signup.html" method="POST" >

<label>Email: <input type="email" required name="email"></label>
<br>

<label>Password: <input type="password" required name="password"></label>
<br>

<label>Confirm Password <input type="password" required name="confirmedPassword"></label>
<br>

<label>Name: <input type="text" required name="name"></label>
<br>

<label>Surname: <input type="text" required name="surname"></label>
<br>

<label>Address: <input type="text" required name="address"></label>
<br>

<input type="submit" value="Sign up">

</form>

<jsp:include page="footer.jsp"/>