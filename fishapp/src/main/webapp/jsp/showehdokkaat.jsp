<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Ehdokkaat" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>

<%
	ArrayList<Ehdokkaat> ehdokkaatList=(ArrayList<Ehdokkaat>)request.getAttribute("ehdokkaatlist");

for (int i=0;ehdokkaatList!=null && i<ehdokkaatList.size();i++){
	Ehdokkaat e=ehdokkaatList.get(i);
%>
<br>
<%
	out.println(e.getId()+": "+e.getEtunimi()+" "+e.getSukunimi()+" "+e.getPuolue()+"<a href='/delete?id="+e.getId()+"'>delete</a> <a href='/readtoupdate?ehdokas_id="+e.getId()+"'>update</a>");
}
%>
<%@ include file="../html/footer.html" %>



</body>
</html>