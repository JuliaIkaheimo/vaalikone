<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>
<div class="container">
<div class="row">
<div class="col-9">

<form action='update' method='post'>
Ehdokas id: <input type='text' name='ehdokas_id' value='${requestScope.vastaukset.ehdokas_id}' readonly><br> 
Ehdokkaan etunimi: <input type='text' name='etunimi' value='${requestScope.vastaukset.vastaus}'><br>

<input type='submit' name='ok' value='Send'> 
</form>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>
