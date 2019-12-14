<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>


<jsp:useBean id="orders" scope="request" type="java.util.List<es.uc3m.eshop.model.MyOrder>"/>
<% final int ROW_MAX_ITEMS = 4; %>

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li class="active"> My Orders </li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
		<h2>My Orders</h2>
		<br>
		<br>
			<!-- row -->
			<div class="row">
				<!-- MAIN -->
				<div id="main" class="col-md-9">
					<!-- STORE -->
					<div id="store">
						<!-- row -->
						<% for(int j = 0; j < orders.size() / ROW_MAX_ITEMS + 1; ++j){ %>
							<div class="row">
								<!-- section title -->
								<% for(int i = ROW_MAX_ITEMS * j; i < Math.min((j + 1) * ROW_MAX_ITEMS, orders.size()); ++i){ %>
									<div class="col-md-3 col-sm-6 col-xs-6">
										<a href="order.html?id=<%=orders.get(i).getIdOrder()%>">
										<div class="product product-single">
											<div class="product-body">
												<h3>ID: <%= orders.get(i).getIdOrder() %></h3>
												<p>Date: <%= orders.get(i).getDate().toString() %></p>
												
												<h5>Total Price: $<%= orders.get(i).getTotal().toString() %></h5>
											</div>
										</div>
										</a>
									</div>
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