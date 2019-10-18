<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<% final int ROW_MAX_ITEMS = 4; %>

<jsp:include page="header.jsp"/>

<jsp:include page="navigation.jsp"/>

<jsp:useBean id="products" scope="request" type="java.util.ArrayList<es.uc3m.eshop.model.Product>"/>

	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- section title -->
				<div class="col-md-12">
					<div class="section-title">
						<h2 class="title">Our Artificial Intelligence Engine Has Chosen These Items For You!</h2>
					</div>
				</div>
				<!-- section title -->
				<% for(int i = 0; i < Math.min(ROW_MAX_ITEMS, products.size()); ++i){ %>
					<!-- Product Single -->
					<div class="col-md-3 col-sm-6 col-xs-6">
						<div class="product product-single">
							<div class="product-thumb">
								<button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
								<img src="./img/product01.jpg" alt="">
							</div>
							<div class="product-body">
								<h3 class="product-price">$<%= products.get(i).getPrice() %></h3>
								<div class="product-rating">
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star-o empty"></i>
								</div>
								<h2 class="product-name"><a href="#"><%= products.get(i).getName() %></a></h2>
								<div class="product-btns">
									<button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
									<button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
									<button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
								</div>
							</div>
						</div>
					</div>
					<!-- /Product Single -->
				<% }%>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->




<jsp:include page="footer.jsp"/>


