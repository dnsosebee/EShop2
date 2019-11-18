<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>

<jsp:include page="header.jsp"/>


<h1>Editing Product</h1>



<table>
	<tr>
	<th>Product ID</th>
	<th>Name</th>
	<th>Description</th>
	<th>Price</th>
	<th>Stock</th>
	<th>Image</th>
	</tr>


	<% Product editProduct = (Product) request.getAttribute("productToEdit");%>
	<tr>
	<form method = "post" action = "editProduct.html">
	<input type = "hidden" name = "productChanges" value = "<%= editProduct.getIdProduct()%>">
	
		<td><%=editProduct.getIdProduct() %></td>
		<td><input type = "text" name = "newProductName" value = "<%=editProduct.getName() %>"></input></td>
		<td><input type = "text" name = "newProductDescription" value = "<%=editProduct.getDescription() %>"></input></td>
		<td><input type = "text" name = "newProductPrice" value = "<%=editProduct.getPrice() %>"></input></td>
		<td><input type = "number" name = "newProductStock" value = "<%=editProduct.getStock() %>"></input></td>
		<td><img src="<%=editProduct.getImageString()%>" width=75px height =75px></td>
		<input  type = "submit" value = "Submit Changes">
	</form>
	</td>

	</tr>

</table>




<jsp:include page="footer.jsp"/>