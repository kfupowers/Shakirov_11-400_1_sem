<%@ page contentType="text/html; UTF-8" language="java" %>

<html>
<head>
    <title>Main page</title>
</head>
<body>
<form action="http://localhost:8080/login">
    <input type="submit" value="login">
</form>

<form action="http://localhost:8080/sign_up">
    <input type="submit" value="signUp">
</form>

<form action="http://localhost:8080/logout">
    <input type="submit" value="logout">
</form>

<form action="http://localhost:8080/user">
    <input type="submit" value="users">
</form>

<%
    String sessionUser = (String) session.getAttribute("user");
    if (sessionUser == null) {
        response.sendRedirect("login.ftl");
    }

    String cookieUser = "";
    String sessionId = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("user".equalsIgnoreCase(c.getName())) {
                cookieUser = c.getValue();
            } else if ("jsessionid".equalsIgnoreCase(c.getName())) {
                sessionId = c.getValue();
            }
        }
    } else {
        sessionId = session.getId();
    }
%>

<h3>
    Hello, <%=sessionUser%>! Login successful
    <br>
    Session ID = <%=sessionId%>
    <br>
    Cookie userForHttp = <%=cookieUser%>
</h3>

</body>

</html>