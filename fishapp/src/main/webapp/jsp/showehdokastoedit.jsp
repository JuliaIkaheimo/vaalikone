<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
<div class="col-9">

<form action='updateehdokas' method='post'>
Ehdokas id: <input type='text' name='ehdokas_id' size="35" value='${requestScope.ehdokkaat.ehdokas_id}' readonly><br> 
Ehdokkaan etunimi: <input type='text' name='etunimi' size="35" value='${requestScope.ehdokkaat.etunimi}'><br>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' size="35" value='${requestScope.ehdokkaat.sukunimi}'><br>
Ehdokkaan puolue: <input type='text' name='puolue' size="35" value='${requestScope.ehdokkaat.puolue}'><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' size="35" value='${requestScope.ehdokkaat.kotipaikkakunta}'><br>
Ikä: <input type='text' name='ika' size="35" value='${requestScope.ehdokkaat.ika}'><br>
Ammatti: <input type='text' name='ammatti' size="35" value='${requestScope.ehdokkaat.ammatti}'><br>
Miksi haluan eduskuntaan?: <input type='text' name='miksi_eduskuntaan' size="35" value='${requestScope.ehdokkaat.miksi_eduskuntaan}'><br>
Mitä asioita haluan edistää?: <input type='text' size="35" name='mita_asioita_haluat_edistaa' value='${requestScope.ehdokkaat.mita_asioita_haluat_edistaa}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>
