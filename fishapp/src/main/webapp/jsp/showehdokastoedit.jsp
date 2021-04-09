<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>
<div class="container">
<div class="row">
<div class="col-9">

<form action='update' method='post'>
Ehdokas id: <input type='text' name='ehdokas_id' value='${requestScope.ehdokkaat.ehdokas_id}' readonly><br> 
Ehdokkaan etunimi: <input type='text' name='etunimi' value='${requestScope.ehdokkaat.etunimi}'><br>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' value='${requestScope.ehdokkaat.sukunimi}'><br>
Ehdokkaan nimi: <input type='text' name='puolue' value='${requestScope.ehdokkaat.puolue}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>