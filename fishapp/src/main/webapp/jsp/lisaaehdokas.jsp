<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>
<div class="container">
<div class="row">
<div class="col-9">

<form action='lisaa' method='post'> 

Ehdokkaan etunimi: <input type='text' name='etunimi' value=''><br>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' value=''><br>
Ehdokkaan puolue: <input type='text' name='puolue' value=''><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value=''><br>
Ikä: <input type='text' name='ika' value=''><br>
Ammatti: <input type='text' name='ammatti' value=''><br>
Miksi haluan eduskuntaan?: <input type='text' name='miksi_eduskuntaan' value=''><br>
Mitä asioita haluan edistää?: <input type='text' name='mita_asioita_haluat_edistaa' value=''><br>
<input type='submit' name='ok' value='Send'> 
</form>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>