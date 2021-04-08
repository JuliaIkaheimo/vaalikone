<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Kysymykset" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>
<div class="container">
<div class="row">
<div class="col-9">
<%
	ArrayList<Kysymykset> kysymyksetList=(ArrayList<Kysymykset>)request.getAttribute("kysymyksetlist");

for (int i=0;kysymyksetList!=null && i<kysymyksetList.size();i++){
	Kysymykset k=kysymyksetList.get(i);
%>
<br>
<%
	out.println(k.getId()+": "+k.getKysymys());
}
%>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>
