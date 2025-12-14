<%@page import="org.apache.catalina.ant.SessionsTask"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>email ${sessionScope.user_detail.email}</h1>
	<h1>Name ${sessionScope.user_detail.name}</h1>
	<h1>Dob ${sessionScope.user_detail.dob}</h1>
	
	<h3><a href="logout.jsp">LogOut Me</a></h3>
</body>
</html>