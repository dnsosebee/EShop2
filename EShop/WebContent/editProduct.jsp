<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>

<div style="margin:30px;">

<h1>Editing Product</h1>



<table>
	<tr>
	<th>Product ID</th>
	<th>Name</th>
	<th>Description</th>
	<th>Price</th>
	<th>Stock</th>
	<th>Image</th>
	<th>Edit Image</th>
	</tr>


	<%
		es.uc3m.eshop.model.Product editProduct = (es.uc3m.eshop.model.Product) request.getAttribute("productToEdit");
	%>
	<tr>
	<form method = "post" action = "editProduct.html" enctype = "multipart/form-data">
	<input type = "hidden" name = "productChanges" value = "<%= editProduct.getIdProduct()%>">
	
		<td><%=editProduct.getIdProduct() %></td>
		<td><input type = "text" name = "newProductName" value = "<%=editProduct.getName() %>"></input></td>
		<td><input type = "text" name = "newProductDescription" value = "<%=editProduct.getDescription() %>"></input></td>
		<td><input type = "text" name = "newProductPrice" value = "<%=editProduct.getPrice() %>"></input></td>
		<td><input type = "number" name = "newProductStock" value = "<%=editProduct.getStock() %>"></input></td>
		<td><img src="<%=editProduct.getImageString()%>" width=75px height =75px></td>
		<td><input type = "file" name = "newProductImage" id = "newProductImage"></td>
		<td><input  type = "submit" value = "Submit Changes"></td>
	</form>
	</td>

	</tr>

</table>


</div>

<jsp:include page="footer.jsp"/>