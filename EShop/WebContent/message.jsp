<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:useBean id="user" scope="session" type="es.uc3m.eshop.model.ApplicationUser"/>

<jsp:include page="header.jsp"/>

<% String titleVal = ""; %>
<% if (request.getParameter("isReply") != null) { %>
	<div style="outline: 2px dashed blue; margin: 30px; padding: 30px">
		<% titleVal = "RE: " + request.getParameter("title"); %>
		<h2><%= request.getParameter("title") %></h2>
		<p style="font-style:italic;color:#99412E"> (posted by 
		<% if (request.getParameter("userType").compareTo("0") == 0) { %>
			Shopper 
		<% } else if (request.getParameter("userType").compareTo("1") == 0) { %>
			Seller
		<% } else if (request.getParameter("userType").compareTo("2") == 0) { %>
			Administrator
		<% } %>
		<%= request.getParameter("email") %>)
		</p>
		<p><%= request.getParameter("message") %></p>
		<br>
	</div>
	<p>Want to respond?</p>
<% } else { %>
	<p> Message for 
	<% if (request.getParameter("allUsers") != null) { %>
		all shoppers:
	<% } else if (request.getParameter("allSellers") != null) { %>
		all sellers:
	<% } else { %>
		<%= request.getParameter("recipientEmail") %>:
	<% } %>
	</p>
<% } %>
<form action="send.html" method="POST" >

<label>Title: <input type="text" required name="title" value="<%= titleVal %>"></label>
<br>

<label>Body: <input type="text" required name="message"></label>
<br>

<% if (request.getParameter("allUsers") != null) { %>
	<input type="hidden" name="allUsers" value=" " />
<% } else if (request.getParameter("allSellers") != null) { %>
<input type="hidden" name="allSellers" value=" " />
<% } else { %>
	<input type="hidden" name="recipientEmail" value="<%=request.getParameter("recipientEmail") %>" />
<% } %>
<input type="hidden" name="senderEmail" value="<%= user.getEmail() %>" />
<input type="hidden" name="userType" value="<%=user.getRole() %>" />

<input type="submit" value="Send Your Message">

</form>

<br><br>

<form action="inbox.html" method="GET" >

<input type="submit" value="Go To Inbox (and don't send your message)">

</form>
<jsp:include page="footer.jsp"/>