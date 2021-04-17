<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.*" %>   

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<%@ include file="headervaalikone.jsp" %>
<div class="container">
<div class="row">
<div class="col-9">
<h3> Ehdokkaat tiedot
<%
ArrayList<Kysymykset> kysymyksetList=(ArrayList<Kysymykset>) request.getAttribute("kysymyksetList");
ArrayList<Vastaukset> vastauksetList=(ArrayList<Vastaukset>) request.getAttribute("vastauksetList");
Ehdokkaat e = (Ehdokkaat) request.getAttribute("ehdokkaat");


%>
<br>
<br>
<img src="images/profile.png" alt="Profiilikuva" width="100" height="100">
<p><b>Nimi: </b> <% out.println(e.getEtunimi()+" "+e.getSukunimi()+ " - " + e.getPuolue()); %></p>
<p><b>Puolue: </b> <% out.println(e.getPuolue()); %></p>
<p><b>Kotipaikkakunta: </b><% out.println(e.getKotipaikkakunta()); %></p>
<p><b>Ikä: </b><% out.println(e.getIka()); %></p>
<p><b>Ammatti: </b> <% out.println(e.getAmmatti()); %></p>
<p><b>Miksi haluan eduskuntaan?: </b><% out.println(e.getMiksi_eduskuntaan()); %></p>
<p><b>Mitä asioita haluan edistää?: </b> <% out.println(e.getMita_asioita_haluat_edistaa()); %></p>
<br>
<h3>Kysymyksten vastaukset:</h3>
<br>
<%
for (int i=0;kysymyksetList!=null && i<kysymyksetList.size();i++){
	Kysymykset k=kysymyksetList.get(i);
	Vastaukset v=vastauksetList.get(i);
	out.println("<h4>"+k.getKysymys_id()+". "+k.getKysymys()+"</h4>");
	%>
	<br>
	<form action='/readehdokas' method='post'>
	<input type="radio" id="1" name="vastaus<%out.print(i+1);%>" value="1" <%if (v.getVastaus() == 1) { out.println("checked"); } %> readonly> <label for="1">Täysin eri mieltä</label>
	<input type="radio" id="2" name="vastaus<%out.print(i+1);%>" value="2" <%if (v.getVastaus() == 2) { out.println("checked"); } %> readonly> <label for="2">Eri mieltä</label>
	<input type="radio" id="3" name="vastaus<%out.print(i+1);%>" value="3" <%if (v.getVastaus() == 3) { out.println("checked"); } %> readonly> <label for="3">En osaa sanoa</label>
	<input type="radio" id="4" name="vastaus<%out.print(i+1);%>" value="4" <%if (v.getVastaus() == 4) { out.println("checked"); } %> readonly> <label for="4">Samaa mieltä</label>
	<input type="radio" id="5" name="vastaus<%out.print(i+1);%>" value="5" <%if (v.getVastaus() == 5) { out.println("checked"); } %> readonly> <label for="5">Täysin samaa mieltä</label>
	<br>
	<p>Ehdokkaan kommentti kysymykseen:<%out.println(" "+v.getKommentti()); %></p>
	</form>
	<br><br>
	<%
}
%>
</div>
</div>
</div>
<%@ include file="../html/footer.html" %>