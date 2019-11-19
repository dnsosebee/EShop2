<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, es.uc3m.eshop.model.*, 
	es.uc3m.eshop.imagemanagement.*, org.apache.commons.codec.binary.StringUtils, org.apache.commons.codec.binary.Base64"%>



<jsp:include page="header.jsp" />

<h3>Database Images:</h3>


<%
	List<DBImage> elementos = new ArrayList<DBImage>();
	Object lista = request.getAttribute("lista");
	if (lista != null) {
		if (lista instanceof List) {
			elementos = (List<DBImage>) lista;
			for (DBImage elemento : elementos) {
%>
<h5>
	Titulo:<%=elemento.getTitle()%>
	(Id_Imagen:
	<%=elemento.getImageID()%>)
</h5>
<!--  This way of displaying the images requires to donwload the library 
						      https://commons.apache.org/proper/commons-codec/download_codec.cgi
			       and put the .jar in the folder  WebContent/WEB-INF/lib/   -->
<!--  It would be better to put this code in an static class with a method used from catalago.jsp -->

<img style="height: 50px;"
	src="<%StringBuilder sb = new StringBuilder();
						sb.append("data:image/png;base64,");
						sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(elemento.getImage(), false)));
						out.print(sb.toString());%>">
<%
	}
		}
	}
%>



<h3>Images from products</h3>

<%List<Product> list = (List<Product>) request.getAttribute("products"); %>

<%for (Product product: list) 
{%>
	
	<p>Product Name: <%=product.getName() %></p>
	<br>
	Product Image
	<img src = "<%= product.getImageString() %>">
<%} %>
<jsp:include page="footer.jsp" />
