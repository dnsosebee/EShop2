<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>

<jsp:include page="navigation.jsp"/>


<% final int ROW_MAX_ITEMS = 4; %>

<jsp:useBean id="products" scope="request" type="java.util.ArrayList<es.uc3m.eshop.model.Product>"/>
<br>
<% if (request.getParameter("term") != null) { %>
	<h1>Items Related to "<%= request.getParameter("term") %>":</h1>
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
	<!-- /BREADCRUMB -->
<% } else { %>
<h1>All Products</h1>
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