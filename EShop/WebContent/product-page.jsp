<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:useBean id="product" scope="request" type="es.uc3m.eshop.model.Product"/>

<jsp:include page="header.jsp"/>

<jsp:include page="navigation.jsp"/>
	
	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li><a href="#">Products</a></li>
				<li class="active"><%= product.getName() %></li>
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
				<!--  Product Details -->
				<div class="product product-details clearfix">
					<div class="col-md-6">
						<div id="product-main-view">
							<div class="product-view">
								<img src="./img/main-product01.jpg" alt="">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="product-body">
							<h2 class="product-name"><%= product.getName() %></h2>
							<h3 class="product-price">$<%= product.getPrice() %></h3>
							<p>
								<strong>Availability:</strong>
								<% if (product.getStock() == 0) { %>
									Sold Out
								<% } else { %>
								<%= product.getStock() %>
								in stock
								<% } %>
							</p>

							<div class="product-btns">
								<div class="qty-input">
									<span class="text-uppercase">QTY: </span>
									<input class="input" type="number">
								</div>
								<button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
							</div>
						</div>
						<div class="product-tab">
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
							</ul>
							<div class="tab-content">
								<div id="tab1" class="tab-pane fade in active">
									<p><%= product.getDescription() %></p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-12">
						
					</div>

				</div>
				<!-- /Product Details -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->
<jsp:include page="footer.jsp"/>