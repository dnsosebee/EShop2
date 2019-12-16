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
			<form id="checkout-form" class="clearfix">
				<div class="col-md-6">
					<div class="billing-details">
						<div class="section-title">
							<h3 class="title">Payment Details</h3>
						</div>
						<div class="form-group">
							<input class="input" type="text" name="paymentFirstName"
								placeholder="First Name">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="paymentLastName"
								placeholder="Last Name">
						</div>
						<div class="form-group">
							<input class="input" type="email" name="cardNumber"
								placeholder="Credit Card Number">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="cardExpiry"
								placeholder="Credit Card Expiry mm/yy">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="cardSecurity"
								placeholder="Credit Card Security">
						</div>
					</div>
				</div>
		</div>
		<div class="pull-right">
					<button class="primary-btn">
						<a href="orderThanks.html">Place Order</a>
					</button>
				</div>


	</div>
	<!-- /row -->
</div>
<!-- /container -->
</div>
<!-- /section -->

<jsp:include page="footer.jsp" />
