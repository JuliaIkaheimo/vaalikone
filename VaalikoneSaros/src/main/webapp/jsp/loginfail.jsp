<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>
<div class="container">
<div class="row">
<div class="col-9">

<form action="login" method="post">
    Käyttäjänimi: <input type="text" name="username"/> <br/>
    Salasana: <input type="password" name="password"/> <br/>
    <input type="submit" value="Kirjaudu" />
</form>

<p> Väärä käyttäjätunnus tai salasana</p>

</div>
</div>
</div>
<%@ include file="../html/footer.html" %>