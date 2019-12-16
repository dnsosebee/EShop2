<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>


	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="orders.html">My Orders</a></li>
				<li class="active"> Recent Order </li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<div style="margin:30px;">
<h2>Your order could not be processed at this time. Please check your credit card information</h2>
<a href = "showCart.html">Return to Cart</a>
</div>
<jsp:include page="footer.jsp"/>