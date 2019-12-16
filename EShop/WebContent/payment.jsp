<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp" />


<%
	HashMap<es.uc3m.eshop.model.Product, Integer> cartItems = (HashMap<es.uc3m.eshop.model.Product, Integer>) session.getAttribute("cartItems");
%>


<!-- BREADCRUMB -->
<div id="breadcrumb">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li class="active">Checkout</li>
		</ul>
	</div>
</div>
<!-- /BREADCRUMB -->

<!-- section -->
<div class="section">
	<!-- container -->
	<div class="container">

		<div class="col-md-12">
			<div class="order-summary clearfix">
				<div class="section-title">
					<h3 class="title">Order Review</h3>
				</div>
				<table class="shopping-cart-table table">
					<thead>
						<tr>
							<th>Product</th>
							<th></th>
							<th class="text-center">Price</th>
							<th class="text-center">Quantity</th>
							<th class="text-center">Total</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Map.Entry<es.uc3m.eshop.model.Product, Integer> entry : cartItems.entrySet()) {
						%>
						<tr>
							<td class="thumb"><img
								src="<%=entry.getKey().getImageString()%>" alt=""></td>
							<td class="details"><a href="#"><%=entry.getKey().getName()%></a>
							</td>
							<td class="price text-center"><strong><%=entry.getKey().getPrice()%></strong></td>
							<td class="qty text-center"><strong><%=entry.getValue()%></strong></td>
							<td class="total text-center"><strong class="primary-color"><%=(entry.getKey().getPrice() * entry.getValue())%></strong></td>
						</tr>
						<%
							}
						%>
					</tbody>
					<tfoot>
						<tr>
							<th class="empty" colspan="3"></th>
							<th>SUBTOTAL</th>
							<th colspan="2" class="sub-total"><%=session.getAttribute("cartCost")%></th>
						</tr>
						<tr>
							<th class="empty" colspan="3"></th>
							<th>SHIPING</th>
							<td colspan="2">Free Shipping</td>
						</tr>
						<tr>
							<th class="empty" colspan="3"></th>
							<th>TOTAL</th>
							<th colspan="2" class="total"><%=session.getAttribute("cartCost")%></th>
						</tr>
					</tfoot>
				</table>
				
			</div>

		</div>
		</form>
		<!-- row -->
		<div class="row">
		
<form action="orderThanks.html" method="POST" >			
<label>First Name: <input type="text" required name="name"></label>
<br>

<label>Last Name: <input type="text" required name="surname"></label>
<br>

<label>Credit Card Number: <input type="number" required name="creditCard"></label>
<br>

<label>Expiration Date: <input type="text" required name="expiry"></label>
<br>

<label>CVV: <input type="number" required name="cvv"></label>
<br>
<input type="submit" value="Submit">

	<!-- /row -->
</div>
<!-- /container -->
</div>
<!-- /section -->

<jsp:include page="footer.jsp" />
