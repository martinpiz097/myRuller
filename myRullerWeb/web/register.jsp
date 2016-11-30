<%-- 
    Document   : register
    Created on : 17-11-2016, 0:06:31
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="register.do" method="POST">
            <label>Nombre: </label>
            <input type="text" name="name" required/>
            
            <label>Edad: :</label>
            <input type="number" name="age" required/>
            
            <label>Usuario:</label>
            <input type="text" name="nick" required/>

            <label>Contraseña: </label>
            <input type="password" name="pass1" required/>

            <label>Repetir Contraseña: </label>
            <input type="password" name="pass2" required/>
            <br>
            <br>
            <input type="submit" value="Registrar" class="btn-primary"/>
        </form>
    </body>
</html>
