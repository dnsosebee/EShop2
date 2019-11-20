<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>



<jsp:include page="header.jsp" />

	<!-- BREADCRUMB -->
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li class="active">Edit Products</li>
			</ul>
		</div>
	</div>
	<!-- /BREADCRUMB -->

<div style="margin:30px;">

<h3>Edit Products</h3>

<table>
	<tr>
		<th>Product ID</th>
		<th>Product Name</th>
		<th>Product Description</th>
		<th>Product Price</th>
		<th>Product Stock</th>
		<th>Product Image</th>
		<th>Edit Product</th>
		<th>Delete Product</th>
	</tr>
	
	<% List<Product> allProducts = (List<Product>) request.getAttribute("allProducts"); %>
	<% for(Product product: allProducts) {%>
	<tr>
		<td><%=product.getIdProduct()%></td>
		<td><%=product.getName()%></td>
		<td><%=product.getDescription()%></td>
		<td><%=product.getPrice() %></td>
		<td><%=product.getStock()%></td>
		<td><img src = "<%=product.getImageString() %>" width = 75px height = 75px></td>
		<td>
		<form method = "post" action = "editProduct.html">
		<input type = "submit" value = "Edit Product"/>
		<input type="hidden" name="editProduct" value="<%=product.getIdProduct()%>" />
		</form>
		</td>
		<td>
		<form method = "post" action = "editProduct.html">
		<input type = "submit" value = "Delete Product">
		<input type = "hidden" name = "deleteProduct" value = "<%=product.getIdProduct() %>">
		</form>
		</td>
	</tr>
	
	
	<%} %>
</table>


</div>

<jsp:include page="footer.jsp" />
