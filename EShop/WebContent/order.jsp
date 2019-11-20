<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:useBean id="order" scope="request" type="es.uc3m.eshop.model.MyOrder"/>

<jsp:include page="header.jsp"/>
<div style="margin:30px;">
<h2> Details for your order with id <%= order.getIdOrder() %></h2>
</div>
<jsp:include page="footer.jsp"/>