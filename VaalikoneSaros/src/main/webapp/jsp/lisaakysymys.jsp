<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
<div class="col-9">

<form action='lisaakysymys' method='post'>

Kysymys: <input type='text' name='kysymys' size="35" value= ''><br>
<input type='submit' name='ok' value='Send'> 
</form>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>