<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%="Le total des requetes est : "+request.getAttribute("total")%>
    <br><br><br>
    <h1>Form</h1>
    <form action="../my-servlet" method="post">
        Id : <input type="text" name="id" > <br><br>
        Nom : <input type="text" name="nom" > <br><br>
        Prénom : <input type="text" name="prenom" ><br><br>
        Date de naissance : <input type="text" name="date" ><br><br>
        CNE : <input type="text" name="cne" ><br><br>
        <input type="submit" value="Envoyer" >
    </form>
</body>
</html>
