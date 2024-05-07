<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String msgErr = (String) request.getAttribute("Erreur");
    %>
    <h1><%=msgErr%></h1>
</body>
</html>
