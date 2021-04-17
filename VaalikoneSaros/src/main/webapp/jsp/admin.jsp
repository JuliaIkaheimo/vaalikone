<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Ehdokkaat" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="header.jsp" %>
<header class="masthead">
  <div class="container h-100">
    <div class="row h-100 align-items-center">
      <div class="col-12">
        <h1 class="font-weight-light">Admin paneeli</h1>
        <p class="lead">Admin voi poistaa/muokata tai lisätä ehdokkaita tai kysymyksiä</p>
      </div>
    </div>
  </div>
</header>
<div class="container">
<div class="row">
<div class="col-9">
<h3>Ehdokkaat</h3>
<table id='t01'>
<c:forEach var="Ehdokkaat" items="${requestScope.ehdokkaatlist}" >
<tr><td>${Ehdokkaat.getEhdokas_id()}. ${Ehdokkaat.getEtunimi()} ${Ehdokkaat.getSukunimi()} - ${Ehdokkaat.getPuolue()} - ${Ehdokkaat.getKotipaikkakunta()}</td> <td><a class='button' href='/deleteehdokas?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'>Poista</a><a class='button' href='/readtoupdateehdokas?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'>Päivitä</a><a class='button' href='/showvastauksettoedit?ehdokas_id=${Ehdokkaat.getEhdokas_id()}'>Kysymykset</a></td></tr>
</c:forEach>
</table>
</div>
<div class="col-3">
<h3>Lisää tietoa:</h3>
<p><a class='button' href='/readehdokastolisaa'>Lisää ehdokas</a></p>
</div>
</div>
<div class="row">
<div class="col-9">
<h3>Kysymykset</h3>
<table id='t01'>
<c:forEach var="Kysymykset" items="${requestScope.kysymyksetlist}" >
<tr><td>${Kysymykset.getKysymys_id()} - ${Kysymykset.getKysymys()}</td>
</c:forEach>
</table>
</div>

<div class="col-3">
<h3>Lisää tietoa:</h3>
<p><a class='button' href='/readkysymystolisaa'>Lisää kysymys</a></p>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>

