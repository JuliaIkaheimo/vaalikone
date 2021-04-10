<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<%@ include file="../html/header.html" %>
<div class="container">
<div class="row">
<div class="col-9">

<form action='update' method='post'> 
Etunimi: <input type='text' name='etunimi' value='${requestScope.ehdokkaat.etunimi}'><br>
Sukunimi: <input type='text' name='sukunimi' value='${requestScope.ehdokkaat.sukunimi}'><br>
Puolue: <input type='text' name='puolue' value='${requestScope.ehdokkaat.puolue}'><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value='${requestScope.ehdokkaat.kotipaikkakunta}'><br>
Ikä: <input type='text' name='ika' value='${requestScope.ehdokkaat.ika}'><br>
Ammatti: <input type='text' name='ammatti' value='${requestScope.ehdokkaat.ammatti}'><br>
Miksi haluan eduskuntaan?: <input type='text' name='miksi_eduskuntaan' value='${requestScope.ehdokkaat.miksi_eduskuntaan}'><br>
Mitä asioita haluan edistää?: <input type='text' name='mita_asioita_haluat_edistaa' value='${requestScope.ehdokkaat.mita_asioita_haluat_edistaa}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>