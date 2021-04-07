<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Ehdokkaat" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone :)</title>

<!-- <link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css"> -->
<!--  <script src="myscriptfile.js"></script>  -->

</head>
<body>
<h2>Vaalikone :)</h2>
<ol>
<c:forEach var="ehdokkaat" items="${requestScope.ehdokkaatlist}" >
<li>${ehdokkaat.ehdokas_id}: ${ehdokkaat.etunimi} <a href='/delete?id=${ehdokkaat.ehdokas_id}'>delete</a> <a href='/readtoupdate?id=${ehdokkaat.ehdokas_id}'>update</a>
</c:forEach>
</ol>

<%
	ArrayList<Ehdokkaat> ehdokkaatList=(ArrayList<Ehdokkaat>)request.getAttribute("ehdokkaatlist");

for (int i=0;ehdokkaatList!=null && i<ehdokkaatList.size();i++){
	Ehdokkaat f=ehdokkaatList.get(i);
	out.println(f.getId()+": "+f.getEtunimi()+"<a href='/delete?id="+f.getId()+"'>delete</a> <a href='/readtoupdate?id="+f.getId()+"'>update</a>");
}
%>

<%@ include file="../html/somehtml.html" %>



</body>
</html>