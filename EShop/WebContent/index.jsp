<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<% final int ROW_MAX_ITEMS = 4; %>

<jsp:include page="header.jsp"/>

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<jsp:useBean id="products" scope="request" class="java.util.ArrayList<es.uc3m.eshop.model.Product>"/>

	<!-- section -->
	<div class="section">
	
		<!-- container -->
		<div class="container">
		<h1>Welcome to EShop!</h1>
		<br>
		<br>
			<!-- row -->
			<div class="row">
				<!-- section title -->
				<div class="col-md-12">
					<div class="section-title">
						<h3 class="title">Picked For You</h3>
					</div>
				</div>
				<!-- section title -->
				<% for(int i = 0; i < Math.min(ROW_MAX_ITEMS, products.size()); ++i){ %>
					<jsp:include page="product.jsp">
				        <jsp:param name="price" value="<%= products.get(i).getPrice() %>" />
				        <jsp:param name="name" value="<%= products.get(i).getName() %>"/>
				        <jsp:param name="id" value="<%= products.get(i).getIdProduct() %>"/>
				        <jsp:param name="image" value = "<%= products.get(i).getImageString() %>" />
				    </jsp:include>
				<% } %>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->




<jsp:include page="footer.jsp"/>


