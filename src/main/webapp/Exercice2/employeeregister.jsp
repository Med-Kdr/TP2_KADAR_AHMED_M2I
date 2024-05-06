<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Employee Register Form</h1>
    <form action="../add-employee" method="post">
        First Name : <input type="text" name="firstName" > <br><br>
        Last Name : <input type="text" name="lastName" ><br><br>
        UserName : <input type="text" name="userName" ><br><br>
        Password : <input type="text" name="password" ><br><br>
        Address : <input type="text" name="address" ><br><br>
        Contact No : <input type="text" name="conact" ><br><br>
        <input type="submit" value="Add" >
    </form>

    <!--CREATE TABLE `employees`.`employee` ( `id` INT NOT NULL AUTO_INCREMENT , `firstName` VARCHAR(50) NOT NULL , `lastName` VARCHAR(50) NOT NULL , `userName` VARCHAR(50) NOT NULL , `password` VARCHAR(100) NOT NULL , `address` VARCHAR(200) NOT NULL , `contact` VARCHAR(200) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;-->


</body>
</html>
