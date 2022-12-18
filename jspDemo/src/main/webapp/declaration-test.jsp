<html>
<body>
<!-- Declaration  -->
<%!
String makeItLower(String data){
	return data.toLowerCase();
}
%>
<!-- Expression  -->
Lower case "Hello World": <%= makeItLower("Hello World")  %>
</body>
</html>