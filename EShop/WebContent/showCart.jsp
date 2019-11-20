<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>


<jsp:include page="header.jsp" />

<div style="margin:30px;">

<h3>Your Cart</h3>
<br>
<span style="font-style:italic;">To remove an item, set quantity to zero.</span>
<br>

<%HashMap<Product, Integer> cartItems = (HashMap<Product, Integer>) session.getAttribute("cartItems"); %>


<form action = "addItemToCart.html" method = "post">

<table>
<tr>
<th>Product Image</th>
<th>Product Name</th>
<th>Price</th>
<th>Quantity</th>
</tr>



<%for(Map.Entry<Product, Integer> entry : cartItems.entrySet()) { %>
<tr>
<td> <img src = "<%=entry.getKey().getImageString() %>" height = 75px width = 75px> </td>
<td><a href="product-page.html?id=<%=entry.getKey().getIdProduct() %>"> <%=entry.getKey().getName() %></a></td>
<td> <%=entry.getKey().getPrice() %></td>
<td> <input min="0" max="<%= entry.getKey().getStock() %>" type = "number" value = "<%= entry.getValue() %>" name = "newProductQuantity_<%=entry.getKey().getIdProduct() %>"> </td>
</tr>

<% } %>

</table>

<br>

<input type="hidden" name="updateCart" value="yes" />
<button type = "submit" value = "update product">Update Cart Quantities</button>
</form>

<br>

<h4>Your cart cost: $<%= session.getAttribute("cartCost") %></h4>

</div>
<jsp:include page="footer.jsp" />