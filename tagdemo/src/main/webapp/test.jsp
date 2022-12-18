<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:set var="stuff" value="<%= new java.util.Date() %>"></c:set>

Time on server is ${stuff}

</body>
</html>