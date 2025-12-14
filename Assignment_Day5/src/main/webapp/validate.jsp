<%@page import="com.dswsd.User"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
private Map<String, User> users=new HashMap<>();

public void jspInit() {
	Date dob1 = Date.valueOf("2001-08-10");
    Date dob2 = Date.valueOf("2001-01-11");
    Date dob3 = Date.valueOf("2001-05-13");
    Date dob4 = Date.valueOf("2001-03-10");
    
	users.put("om@gmail.com", new User("Om", "om@gmail.com", "pass@123", dob1));
	users.put("shubham@gmail.com", new User("Shubham", "shubham@gmail.com", "pass@123", dob2));
	users.put("karan@gmail.com", new User("Karan", "karan@gmail.com", "pass@123", dob3));
	users.put("om@gmail.com", new User("Omkar", "karan@gmail.com", "pass@123", dob4));
}

%>
<body>
	<%
		String email=request.getParameter("em");
		String pass=request.getParameter("pass");
		
		User us=users.get(email);
		System.out.print(us.toString());
		if(us!=null){
			
			if(us.getPassword().equals(pass)){
				session.setAttribute("user_detail", us);
				response.sendRedirect("details.jsp");
			}
		}
		//response.sendRedirect("login.jsp");
	%>
</body>
</html>