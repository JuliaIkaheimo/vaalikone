<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.*" %>   

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
<div class="col-9">
<h2>
<%
ArrayList<Kysymykset> kysymyksetList=(ArrayList<Kysymykset>) request.getAttribute("kysymyksetList");
ArrayList<Vastaukset> vastauksetList=(ArrayList<Vastaukset>) request.getAttribute("vastauksetList");
Ehdokkaat e = (Ehdokkaat) request.getAttribute("ehdokkaat");

out.println(e.getEtunimi()+" "+e.getSukunimi()+ " - " + e.getPuolue());
%>
</h2>
<br><br>
<form action='updatevastaukset' method='post'>
<%
for (int i=0;kysymyksetList!=null && i<kysymyksetList.size();i++){
	Kysymykset k=kysymyksetList.get(i);
	Vastaukset v=vastauksetList.get(i);
	out.println(k.getKysymys_id()+": "+k.getKysymys());
	%>
	<br>

	<input type="radio" id="1" name="vastaus<%out.print(i+1);%>" value="1" <%if (v.getVastaus() == 1) { out.println("checked"); } %>> <label for="1">Täysin eri mieltä</label>
	<input type="radio" id="2" name="vastaus<%out.print(i+1);%>" value="2" <%if (v.getVastaus() == 2) { out.println("checked"); } %>> <label for="2">Eri mieltä</label>
	<input type="radio" id="3" name="vastaus<%out.print(i+1);%>" value="3" <%if (v.getVastaus() == 3) { out.println("checked"); } %>> <label for="3">En osaa sanoa</label>
	<input type="radio" id="4" name="vastaus<%out.print(i+1);%>" value="4" <%if (v.getVastaus() == 4) { out.println("checked"); } %>> <label for="4">Samaa mieltä</label>
	<input type="radio" id="5" name="vastaus<%out.print(i+1);%>" value="5" <%if (v.getVastaus() == 5) { out.println("checked"); } %>> <label for="5">Täysin samaa mieltä</label>
	<br>
	<label for="kommentti">Kommentti:  </label><input type='text'  id="kommentti" name='kommentti' size="35" value='<%out.println(v.getKommentti()); %>'>
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