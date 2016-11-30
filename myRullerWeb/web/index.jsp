<%-- 
    Document   : index
    Created on : 16-11-2016, 16:40:21
    Author     : martin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("client") != null) {
        response.sendRedirect("menu.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <form action="login.do" method="post">
                <label>Usuario:</label>
                <input type="text" name="user" required/>

                <label>Contraseña: </label>
                <input type="password" name="passw" required/>
                <br>
                <br>
                <input type="submit" value="Ingresar" class="btn-primary"/>
            </form>
            <br>
            <a href="register.jsp"><button class="btn-success">Registrarse</button></a>
        </div>

    </body>
</html>
