<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Ehdokkaat" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%@ include file="../html/header.html" %>

<%
	ArrayList<Ehdokkaat> ehdokkaatList=(ArrayList<Ehdokkaat>)request.getAttribute("ehdokkaatlist");

for (int i=0;ehdokkaatList!=null && i<ehdokkaatList.size();i++){
	Ehdokkaat f=ehdokkaatList.get(i);
%>
<br>
<%
	out.println(f.getId()+": "+f.getEtunimi()+" "+f.getSukunimi()+" "+f.getPuolue()+"<a href='/delete?id="+f.getId()+"'>delete</a> <a href='/readtoupdate?id="+f.getId()+"'>update</a>");
}
%>
<%@ include file="../html/footer.html" %>



</body>
</html>