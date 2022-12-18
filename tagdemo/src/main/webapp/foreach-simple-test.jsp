<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
String[] cities ={"Mumbai","Delhi","Pune"};
pageContext.setAttribute("myCities",cities);

%>
<body>
<c:forEach var="tempCity" items="${myCities}">
${tempCity}<br>

</c:forEach>


</body>


</html>