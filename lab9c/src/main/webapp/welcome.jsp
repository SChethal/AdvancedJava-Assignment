<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

<%
String name = request.getParameter("uname");

if(name != null && !name.isEmpty()){
    out.print("<h2>Welcome " + name + "!</h2>");
    
    // Store in session
    session.setAttribute("user", name);

    // Set session expiry to 1 minute
    session.setMaxInactiveInterval(60);

    out.print("<p>Session has started...</p>");
    out.print("<p>Your name is stored in session.</p>");
    out.print("<p>Session will expire in 1 minute.</p>");
}
%>

<p>
Click below link within 1 minute to check session:
</p>

<a href="second.jsp">Display the value</a>

</body>
</html>