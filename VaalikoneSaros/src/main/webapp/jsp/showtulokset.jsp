<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ include file="headervaalikone.jsp" %>
<header class="masthead">
   <div class="container h-100">
      <div class="row h-100 align-items-center">
         <div class="col-12">
            <h1 class="font-weight-light">Vaalikoneen tulokset</h1>
            <p class="lead">Eniten samaa mieltä kanssasi olivat nämä ehdokkaat</p>
         </div>
      </div>
   </div>
</header>
<div class="container">
   <div class="row">
      <div class="col-9">
         <c:forEach var="Ehdokkaat" items="${requestScope.ehdokkaatlist}" >
            <p><b>${Ehdokkaat.getVertailu()}%</b> <img src="images/profile.png" alt="Profiilikuva" width="100" height="100">  ${Ehdokkaat.getEtunimi()} ${Ehdokkaat.getSukunimi()} ${Ehdokkaat.getPuolue()}}<a href='/showehdokkaanprofiili?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'> Katso ehdokkaan profiili </a></p>
         </c:forEach>
      </div>
   </div>
</div>
<%@ include file="../html/footer.html" %>