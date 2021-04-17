<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
<div class="col-9">

<h1>Ehdokkaan profiili</h1>
<h2>${requestScope.ehdokkaat.etunimi} ${requestScope.ehdokkaat.sukunimi}</h2>
<p><b>Puolue:</b> ${requestScope.ehdokkaat.puolue}</p>
<p><b>Kotipaikkakunta:</b> ${requestScope.ehdokkaat.kotipaikkakunta}</p>
<p><b>Ikä:</b> ${requestScope.ehdokkaat.ika} </p>
<p><b>Ammatti:</b> ${requestScope.ehdokkaat.ammatti}</p>
<p><b>Miksi haluan eduskuntaan?:</b> ${requestScope.ehdokkaat.miksi_eduskuntaan}</p>
<p><b>Mitä asioita haluan edistää?:</b> ${requestScope.ehdokkaat.mita_asioita_haluat_edistaa}</p>

</div>
</div>
</div>
<%@ include file="../html/footer.html" %>