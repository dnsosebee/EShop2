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
		<!-- row -->
		<div class="row">
			<form id="checkout-form" class="clearfix">
				<div class="col-md-6">
					<div class="billing-details">
						<%
							if (session.getAttribute("user") == null) {
						%>
						<p>
							Already a customer ? <a href="#">Login</a>
						</p>
						<%
							}
						%>
						<div class="form-group">
							<input class="input" type="text" name="first-name"
								placeholder="First Name">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="last-name"
								placeholder="Last Name">
						</div>
						<div class="form-group">
							<input class="input" type="email" name="email"
								placeholder="Email">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="address"
								placeholder="Address">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="city" placeholder="City">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="country"
								placeholder="Country">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="zip-code"
								placeholder="ZIP Code">
						</div>
						<div class="form-group">
							<input class="input" type="tel" name="tel"
								placeholder="Telephone">
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<div class="shiping-methods">
						<div class="section-title">
							<h4 class="title">Shipping Methods</h4>
						</div>
						<div class="input-checkbox">
							<input type="radio" name="shipping" id="shipping-1" checked>
							<label for="shipping-1">Free Shiping - $0.00</label>
							<div class="caption">
								<p>You have qualified for free shipping!
								<p>
							</div>
						</div>
						<!-- <div class="input-checkbox">
								<input type="radio" name="shipping" id="shipping-2">
								<label for="shipping-2">Standard - $4.00</label>
								<div class="caption">
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
										<p>
								</div>
							</div> -->
					</div>

					<div class="payments-methods">
						<div class="section-title">
							<h4 class="title">Payments Methods</h4>
						</div>
						<div class="input-checkbox">
							<input type="radio" name="payments" id="payments-1" checked>
							<label for="payments-1">Direct Bank Transfer</label>
							<div class="caption">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna
									aliqua. Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea commodo consequat.
								<p>
							</div>
						</div>
						<div class="input-checkbox">
							<input type="radio" name="payments" id="payments-2"> <label
								for="payments-2">Cheque Payment</label>
							<div class="caption">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna
									aliqua. Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea commodo consequat.
								<p>
							</div>
						</div>
						<div class="input-checkbox">
							<input type="radio" name="payments" id="payments-3"> <label
								for="payments-3">Paypal System</label>
							<div class="caption">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna
									aliqua. Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea commodo consequat.
								<p>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-12">
					<div class="order-summary clearfix">
						<div class="section-title">
							<h3 class="title">Order Review</h3>
							<h4>
								<a href="showCart.html" color="orange">Review Cart</a>
								<h4>
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
									<td class="total text-center"><strong
										class="primary-color"><%=(entry.getKey().getPrice() * entry.getValue())%></strong></td>
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
						<div class="pull-right">
			
							<button class="primary-btn" onclick="window.location.href = 'payment.jsp';"><a href = "payment.jsp">Proceed
								To Payment</a></button>
						</div>
						<a href = "payment.jsp">Proceed to Payment</a>
					</div>

				</div>
			</form>
		</div>
		<!-- /row -->
	</div>
	<!-- /container -->
</div>
<!-- /section -->

<jsp:include page="footer.jsp" />
