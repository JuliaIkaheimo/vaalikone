<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>
<div class="container">
<div class="row">
<div class="col-9">

<form name="loginForm" method="post" action="loginServlet">
    Käyttäjänimi: <input type="text" name="username"/> <br/>
    Salasana: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login" />
</form>

</div>
</div>
</div>
<%@ include file="../html/footer.html" %>