<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Ehdokkaat" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>
<div class="container">
<div class="row">
<div class="col-9">
<ol>
<c:forEach var="Ehdokkaat" items="${requestScope.ehdokkaatlist}" >
<li>${Ehdokkaat.getId()} ${Ehdokkaat.getEtunimi()} ${Ehdokkaat.getSukunimi()} - ${Ehdokkaat.getPuolue()}<a href='/delete?ehdokas_id=${Ehdokkaat.getId()}'> delete </a> <a href='/readtoupdate?ehdokas_id=${Ehdokkaat.getId()}'> update </a>
</c:forEach>
</ol>
<ol>
<%
	ArrayList<Ehdokkaat> ehdokkaatList=(ArrayList<Ehdokkaat>)request.getAttribute("ehdokkaatlist");

for (int i=0;ehdokkaatList!=null && i<ehdokkaatList.size();i++){
	Ehdokkaat e=ehdokkaatList.get(i);
%>
<br>
<%
	out.println("<li> "+e.getEtunimi()+" "+e.getSukunimi()+" - "+e.getPuolue()+"<a href='/delete?ehdokas_id="+e.getId()+"'> delete </a> <a href='/readtoupdate?ehdokas_id="+e.getId()+"'> update </a>");
}
%>
</ol>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>
