<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
<div class="col-9">

<form action='lisaaehdokas' method='post'> 
<table id='t01'>
<tr><td>Ehdokkaan etunimi: </td><td><input type='text' name='etunimi' size="20" value=''></td></tr>
<tr><td>Ehdokkaan sukunimi: </td><td><input type='text' name='sukunimi' size="20" value=''></td></tr>
<tr><td>Ehdokkaan puolue: </td><td><input type='text' name='puolue' size="20" value=''></td></tr>
<tr><td>Kotipaikkakunta: </td><td><input type='text' name='kotipaikkakunta' size="20" value=''></td></tr>
<tr><td>Ikä: </td><td><input type='text' name='ika' size="20" value=''></td></tr>
<tr><td>Ammatti: </td><td><input type='text' name='ammatti' size="20" value=''></td></tr>
<tr><td>Miksi haluan eduskuntaan?: </td><td><input type='text' name='miksi_eduskuntaan' size="100" value=''></td></tr>
<tr><td>Mitä asioita haluan edistää?: </td><td><input type='text' name='mita_asioita_haluat_edistaa' size="100" value=''></td></tr>
</table>
<input class='btn btn-outline-success my-2 my-sm-0' type='submit' name='ok' value='Lisää ehdokas'> 
</form>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>