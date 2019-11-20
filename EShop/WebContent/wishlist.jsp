<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>s

<h1>Wishlist</h1>
	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li class="active">Wishlist</li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<% final int ROW_MAX_ITEMS = 4; %>

<jsp:useBean id="products" scope="request" type="java.util.List<es.uc3m.eshop.model.Product>"/>

	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- MAIN -->
				<div id="main" class="col-md-9">
					<!-- STORE -->
					<div id="store">
						<!-- row -->
						<% for(int j = 0; j < products.size() / ROW_MAX_ITEMS + 1; ++j){ %>
							<div class="row">
								<!-- section title -->
								<% for(int i = ROW_MAX_ITEMS * j; i < Math.min((j + 1) * ROW_MAX_ITEMS, products.size()); ++i){ %>
									<jsp:include page="product.jsp">
								        <jsp:param name="price" value="<%= products.get(i).getPrice() %>" />
								        <jsp:param name="name" value="<%= products.get(i).getName() %>"/>
								        <jsp:param name="id" value = "<%= products.get(i).getIdProduct() %>"/>
								        <jsp:param name="wishlist" value = " " />
								    </jsp:include>
								 
								<% } %>
							</div>
						<% } %>
						<!-- /row -->
					</div>
					<!-- /STORE -->
				</div>
				<!-- /MAIN -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->

<jsp:include page="footer.jsp"/>