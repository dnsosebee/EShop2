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
				<button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
				<form action="addToWishlist.html" method="POST">
			    	<input type="hidden" name="id" value="<%= request.getParameter("id") %>" />
			    	<input type="submit" value = "Add To Wishlist" style="color:green;margin-top:10px;" />
			    </form>
				<% if (request.getParameter("wishlist") != null) { %>
					<form action="removeFromWishlist.html" method="POST">
				    	<input type="hidden" name="id" value="<%= request.getParameter("id") %>" />
				    	<input type="submit" value = "Remove From Wishlist" style="color:red;margin-top:10px;" />
				    </form>
				<% } %>
			</div>
		</div>
	</div>
</div>
<!-- /Product Single -->