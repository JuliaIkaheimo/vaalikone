<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Kysymykset" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
<div class="col-9">
<form action='readandcompare' method='post'>
<%
	ArrayList<Kysymykset> kysymyksetList=(ArrayList<Kysymykset>)request.getAttribute("kysymyksetlist");

for (int i=0;kysymyksetList!=null && i<kysymyksetList.size();i++){
	Kysymykset k=kysymyksetList.get(i);
	out.println(k.getKysymys_id()+": "+k.getKysymys());
	%>
	<br>
	
	<input type="radio" id="1" name="vastaus<%out.print(i+1);%>" value="1"> <label for="1">Täysin eri mieltä</label>
	<input type="radio" id="2" name="vastaus<%out.print(i+1);%>" value="2"> <label for="2">Eri mieltä</label>
	<input type="radio" id="3" name="vastaus<%out.print(i+1);%>" value="3"> <label for="3">En osaa sanoa</label>
	<input type="radio" id="4" name="vastaus<%out.print(i+1);%>" value="4"> <label for="4">Samaa mieltä</label>
	<input type="radio" id="5" name="vastaus<%out.print(i+1);%>" value="5"> <label for="5">Täysin samaa mieltä</label>
	
	<br><br>
	<%
}
%>
<input type='submit' name='ok' value='Lähetä vastauksesi'> 
</form>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>
