<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, es.uc3m.eshop.model.*"%>



<jsp:include page="header.jsp" />

<h3>Upload database images</h3>
<h3>Form to upload a new picture</h3>

<form method="post" action="databaseImages.html" enctype="multipart/form-data">
	<input type="hidden" name="accion" value="insertarBBDD">
    Select image to upload:
    <input type="file" name="fileToUpload" id="fileToUpload">
    Title:
     <input type="text" name="titulo">
    <input type="submit" value="Upload Image" name="submit">
</form>

<jsp:include page="footer.jsp" />
