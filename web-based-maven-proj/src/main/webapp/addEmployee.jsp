<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><%= session.getAttribute("message") %></h3>
<form method="post" action="AddEmployeeServlet">
Enter empno : <input type="text" name="empno" /> <br/>
Enter name : <input type="text" name="name" /> <br/>
Enter salary : <input type="text" name="salary" /> <br/>
<input type="submit" value="Add" />
</form>
</body>
</html>