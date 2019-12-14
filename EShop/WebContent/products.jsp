<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>

<% final int ROW_MAX_ITEMS = 4; %>

<jsp:useBean id="products" scope="request" type="java.util.ArrayList<es.uc3m.eshop.model.Product>"/>

<% if (request.getParameter("term") != null) { %>
	
	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="products.html">Products</a></li>
				<li class="active">Products Containing <%= request.getParameter("term") %></li>
			</ul>
		</div>
	</div>
	<h1 style="margin-left:100px; margin-top:40px; ">Items Related to "<%= request.getParameter("term") %>":</h1>
	<!-- /BREADCRUMB -->
<% } else { %>

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li class="active">Products</li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->
<h1 style="margin-left:100px; margin-top:40px; ">All Products</h1>
<% } %>
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
								        <jsp:param name="id" value="<%= products.get(i).getIdProduct() %>"/>
								        <jsp:param name="image" value = "<%= products.get(i).getImageString() %>" />
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