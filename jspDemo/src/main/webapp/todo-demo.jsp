<%@ page import="java.util.*" %>
<html>
<body>
<!--                step 1:Create HTML form                 -->

	<form action="todo-demo.jsp">
		Add new item: <input type="text" name="theItem">                   
		
		 <input type="submit" value="Submit">
    </form>
  
    
 <!--    step 2:Add new item to "ToDo" list                 -->
	
	<%
	//Scriptlet tag for 1 or more line of java code
	//1)get the TO DO items from the session

	List<String> items = (List<String>) session.getAttribute("myToDoList");
			
	//2)if the TO DO items doesn't exist ,then create a new one
	
	if(items==null){
		items =new ArrayList<String>();
		session.setAttribute("myToDoList",items);
	 }
	
	//3)see if there is form data to add 
	 
		String theItem = request.getParameter("theItem");
    	// UPDATED CODE BLOCK FOR booleans and if/then statement
    	//
    	boolean isItemNotEmpty = theItem != null && theItem.trim().length() > 0;
    	boolean isItemNotDuplicate = theItem != null && !items.contains(theItem.trim());
    	
    	if (isItemNotEmpty && isItemNotDuplicate) {    		
    		items.add(theItem.trim());    		
    	}
	
	%>
		
<!--      step 3:Display all "To Do" item from session            -->
<hr>
<b>To List Items</b><br>

<ol>
	<%
	
	for (String temp: items){
		out.println("<li>"+temp+"</li>");
		
	}
	%>
</ol>

</body>
</html>