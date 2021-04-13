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
<li>${Ehdokkaat.getEhdokas_id()} ${Ehdokkaat.getEtunimi()} ${Ehdokkaat.getSukunimi()} - ${Ehdokkaat.getPuolue()} - ${Ehdokkaat.getKotipaikkakunta()}<a href='/deleteehdokas?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'> delete </a> <a href='/readtoupdateehdokas?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'> update </a><a href='/showvastauksettoedit?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'> kysymyksiin vastaus </a>
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
	out.println("<li> "+e.getEtunimi()+" "+e.getSukunimi()+" - "+e.getPuolue()+" - "+e.getKotipaikkakunta()+"<a href='/deleteehdokas?ehdokas_id="+e.getEhdokas_id()+"'> delete </a> <a href='/readtoupdateehdokas?ehdokas_id="+e.getEhdokas_id()+"'> update </a>");
}
%>
</ol>

</div>
<a href='/readehdokastolisaa'>Lisää ehdokas</a>
</div>
</div>
<%@ include file="../html/footer.html" %>



