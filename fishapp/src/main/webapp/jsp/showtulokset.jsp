<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>
<div class="container">
<div class="row">
<div class="col-9">
<ol>
<c:forEach var="Ehdokkaat" items="${requestScope.ehdokkaatlist}" >
<li>${Ehdokkaat.getEtunimi()} ${Ehdokkaat.getSukunimi()} ${Ehdokkaat.getPuolue()} ${requestScope.vertailulist[0]}
</c:forEach>
</ol>


</div>
</div>
</div>
<%@ include file="../html/footer.html" %>
