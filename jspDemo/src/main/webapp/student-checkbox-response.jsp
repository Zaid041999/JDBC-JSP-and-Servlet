<html>
<head>
<title>Student Confirmation Title</title>
</head>
<body>

	The student is confirmed:${param.firstName} ${param.lastName}
	<br>
	<br>
	Favorite Programming Languages:<br>
	<!-- Display list of "favoriteLanguage" -->
	<ul>
		<%
		String[] langs = request.getParameterValues ("favoriteLanguage");
		if(langs!=null){
		for (String tempLang : langs) {
			out.println("<li>"+tempLang+"</li>");
		}
		}
		%>
	</ul>
</body>
</html>