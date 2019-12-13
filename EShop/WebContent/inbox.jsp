<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>

<jsp:useBean id="messages" scope="request" type="java.util.ArrayList<es.uc3m.eshop.model.Message>"/>

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li class="active"> Inbox </li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<div style="margin:30px;">

<h1>Your Inbox</h1>
<br>
<span style="font-style:italic">Click on a message to read its content or to respond.</span>
<br>
<% for (Message m: messages) { %>
	<% StringBuilder sb = new StringBuilder(); %>
	<% sb.append("From "); %>
	<% sb.append(m.getSender()); %>
	<% sb.append(": "); %>
	<% sb.append(m.getSubject()); %>
	<br>
	<form action="message.html" method="POST">
	<input type="hidden" name="title" value="<%= m.getSubject() %>" />
	<input type="hidden" name="message" value="<%= m.getBody() %>" />
	<input type="hidden" name="isReply" value=" " />
	<input type="hidden" name="email" value="<%= m.getSender() %>" />
	<input type="hidden" name="recipientEmail" value="<%= m.getRecipient() %>" />
	<input type="submit" value="<%= sb.toString() %>">
	</form>
<% } %>
</div>
<jsp:include page="footer.jsp"/>