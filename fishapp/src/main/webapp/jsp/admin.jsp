<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Ehdokkaat" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
<div class="col-9">
<ol>
<c:forEach var="Ehdokkaat" items="${requestScope.ehdokkaatlist}" >
<li>${Ehdokkaat.getEtunimi()} ${Ehdokkaat.getSukunimi()} - ${Ehdokkaat.getPuolue()} - ${Ehdokkaat.getKotipaikkakunta()}<a href='/deleteehdokas?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'> delete </a> <a href='/readtoupdateehdokas?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'> update </a><a href='/showvastauksettoedit?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'> kysymyksiin vastaus </a>
</c:forEach>
</ol>
<ol>
<c:forEach var="Kysymykset" items="${requestScope.kysymyksetlist}" >
<li>${Kysymykset.getKysymys_id()} - ${Kysymykset.getKysymys()}
</c:forEach>
</ol>

</div>
<a href='/readehdokastolisaa'>Lisää ehdokas</a>
<a href='/readkysymystolisaa'>Lisää kysymys</a>
</div>
</div>
<%@ include file="../html/footer.html" %>

