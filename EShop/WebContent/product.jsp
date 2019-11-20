<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "org.apache.commons.codec.binary.StringUtils, org.apache.commons.codec.binary.Base64"%>


<!-- Product Single -->
<div class="col-md-3 col-sm-6 col-xs-6">
	<div class="product product-single">
		<div class="product-thumb">
			<img src="<%= request.getParameter("image") %>" alt="<%=request.getParameter("name")%>">
		</div>
		
		<div class="product-body">
			<h3 class="product-price">$<%= request.getParameter("price") %></h3>
			<h2 class="product-name"><a href="product-page.html?id=<%=request.getParameter("id")%>"><%= request.getParameter("name") %></a></h2>
			<div class="product-btns">
			<% if (false) { %>
				<form action = "addToCart.html" method = "post">
				<input type = "hidden" name = "cartProductID" value = <%=request.getParameter("id") %>>
<%-- 				<input type = "hidden"  name = "cartProductAmount" value = <%= %>
 --%>				<button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
				</form>
				<% } %>
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