<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>


<form action="message.html" method="POST" >

<input type="hidden" name="allUsers" value=" " />

<input type="submit" value="New message to all shoppers">

</form>


<form action="message.html" method="POST" >

<input type="hidden" name="allSellers" value=" " />

<input type="submit" value="New message to all sellers">

</form>


<form action="message.html" method="POST" >

<input type="hidden" name="recipientEmail" value="1@1" />

<input type="submit" value="New message to specific user">

</form>


<form action="message.html" method="POST" >

<input type="hidden" name="recipientEmail" value="1@1" />
<input type="hidden" name="email" value="senderToReplyTo@gmail.com" />
<input type="hidden" name="title" value="Notice" />
<input type="hidden" name="message" value="We're all out of shoes." />
<input type="hidden" name="userType" value="1" />
<input type="hidden" name="isReply" value=" " />

<input type="submit" value="Reply to a previous message">

</form>


<jsp:include page="footer.jsp"/>