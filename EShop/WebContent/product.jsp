<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- Product Single -->
<div class="col-md-3 col-sm-6 col-xs-6">
	<div class="product product-single">
		<div class="product-thumb">
			<button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
			<img src="./img/product01.jpg" alt="">
		</div>
		<div class="product-body">
			<h3 class="product-price">$<%= request.getParameter("price") %></h3>
			<div class="product-rating">
				<i class="fa fa-star"></i>
				<i class="fa fa-star"></i>
				<i class="fa fa-star"></i>
				<i class="fa fa-star"></i>
				<i class="fa fa-star-o empty"></i>
			</div>
			<h2 class="product-name"><a href="#"><%= request.getParameter("name") %></a></h2>
			<div class="product-btns">
				<button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
				<button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
				<button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
			</div>
		</div>
	</div>
</div>
<!-- /Product Single -->