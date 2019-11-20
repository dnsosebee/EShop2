<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:useBean id="order" scope="request" type="es.uc3m.eshop.model.MyOrder"/>

<jsp:include page="header.jsp"/>

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="orders.html">My Orders</a></li>
				<li class="active"> Order <%=order.getIdOrder() %> </li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<div style="margin:30px;">
<h2> Details for your order with id <%= order.getIdOrder() %></h2>
<p>This order was made on <%=order.getDate().toString() %>.</p>
<br>
<br>
<table>
<tr>
<th>Product Image</th>
<th>Product Name</th>
<th>Price</th>
<th>Quantity</th>
</tr>



<%for(OrderProduct op : order.getOrderProducts()) { %>
<tr>
<td> <img src = "<%=op.getProduct().getImageString() %>" height = 75px width = 75px> </td>
<td><a href="product-page.html?id=<%=op.getProduct().getIdProduct() %>"> <%=op.getProduct().getName() %></a></td>
<td> <%=op.getProduct().getPrice() %></td>
<td> <%=op.getQuantity() %></td>
</tr>

<% } %>

</table>

<br>

<h4>Total cost of this order: $<%= order.getTotal() %></h4>


</div>
<jsp:include page="footer.jsp"/>