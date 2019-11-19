<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>


<jsp:include page="header.jsp" />


<h3>Here we have the cart</h3>


<%HashMap<Product, Integer> cartItems = (HashMap<Product, Integer>) session.getAttribute("cartItems"); %>



<table>
<tr>
<th>Product Image</th>
<th>Product Name</th>
<th>Quantity</th>
<th>Price</th>
<th>Remove Item</th>
</tr>



<%for(Map.Entry<Product, Integer> entry : cartItems.entrySet()) { %>
<tr>
<td> <img src = "<%=entry.getKey().getImageString() %>" height = 75px width = 75px> </td>
<td> <%=entry.getKey().getName() %></td>
<td> <%=entry.getKey().getPrice() %></td>
<td> <input type = "number" value = "<%= entry.getValue() %>" name = "newProductQuantity_<%=entry.getKey().getIdProduct() %>"> </td>
<td>
<form action = "addToCart.html" method = "post">
<input type = "hidden" name = "deleteItem" value = "<%=entry.getKey().getIdProduct() %>"/>
<button type = "submit" value = "Delete Product">Delete Item</button>
</form>
</td>
</tr>

<% } %>

</table>

<form action = "addToCart.html" method = "post">
<input type="hidden" name="updateCart" value="yes" />
<button type = "submit" value = "update product">Update Cart</button>
</form>


<h4>Your cart cost: <%= session.getAttribute("cartCost") %></h4>

<jsp:include page="footer.jsp" />