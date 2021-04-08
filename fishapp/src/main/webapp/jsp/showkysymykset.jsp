<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Kysymykset" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header2.html" %>
<div class="container">
<div class="row">
<div class="col-9">
<%
	ArrayList<Kysymykset> kysymyksetList=(ArrayList<Kysymykset>)request.getAttribute("kysymyksetlist");

for (int i=0;kysymyksetList!=null && i<kysymyksetList.size();i++){
	Kysymykset k=kysymyksetList.get(i);
	out.println(k.getId()+": "+k.getKysymys());
	%>
	<br>
	<form action='update' method='post'>
	<input type="radio" id="1" name="vastaus${i}" value="1"> <label for="1">Täysin eri mieltä</label>
	<input type="radio" id="2" name="vastaus${i}" value="2"> <label for="2">Eri mieltä</label>
	<input type="radio" id="3" name="vastaus${i}" value="3"> <label for="3">En osaa sanoa</label>
	<input type="radio" id="4" name="vastaus${i}" value="4"> <label for="4">Samaa mieltä</label>
	<input type="radio" id="5" name="vastaus${i}" value="5"> <label for="5">Täysin samaa mieltä</label>
	</form>
	<br><br>
	<%
}
%>
<input type='submit' name='ok' value='Lähetä vastauksesi'> 

</div>
</div>
</div>
<%@ include file="../html/footer.html" %>
