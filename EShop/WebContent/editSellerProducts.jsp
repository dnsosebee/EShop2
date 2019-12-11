<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>

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

<h1>View and Edit Products</h1>

<%
	List<es.uc3m.ctw.model.Product> sellerProducts = (List<es.uc3m.ctw.model.Product>) request.getAttribute("sellerProducts");
%>


<table>
	<tr>
	<th>Product ID</th>
	<th>Name</th>
	<th>Description</th>
	<th>Price</th>
	<th>Stock</th>
	<th>Image</th>
	<th>Edit Product</th>
	<th>Delete Product</th>
	</tr>


	<%
		for (es.uc3m.ctw.model.Product product : sellerProducts) {
	%>
	<tr>
		<td><%=product.getIdProduct() %>
		<td><%=product.getName()%></td>
		<td><%=product.getDescription()%></td>
		<td><%=product.getPrice()%></td>
		<td><%=product.getStock()%></td>
		<td><img src="<%=product.getImageString()%>" width=75px height =75px></td>
		<td>
		<form method = "post" action = "editProduct.html">
		<input type = "submit" value = "Edit Product">
		<input type = "hidden" name = "editProduct" value = "<%= product.getIdProduct() %>">
		</form>
		</td>
		<td>
		<form method = "post" action = "editProduct.html">
		<input type = "submit" value = "Delete Product">
		<input type = "hidden" name = "deleteProduct" value = "<%=product.getIdProduct() %>">
		</form>
		</td>
		

	</tr>
	<%
		}
	%>

</table>


</div>

<jsp:include page="footer.jsp"/>