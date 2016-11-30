<%-- 
    Document   : menu
    Created on : 17-11-2016, 0:00:04
    Author     : martin
--%>
<%@page import="org.martin.myRuller.db.ClientDAO"%>
<%@page import="org.martin.myRuller.model.Menstruation"%>
<%@page import="org.martin.myRuller.model.Client"%>
<%
    Client cli = (Client)session.getAttribute("client");
    if(cli == null){
        response.sendRedirect("index.jsp");
        return;
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="divTitle">
            <hr>
            <h1>Menú del cliente</h1>
            <hr>
        </div>
        <br>
        <div class="divContent">
            <h3>Bienvenida señorita <% out.println(cli.getName()); %></h3>
            <%
                
                out.println("<h4 id='txtAlert'>");
                if(cli.hasMenstruations()){
                    Menstruation lastMens = new ClientDAO().getLastMenstruation(cli.getId());
                    if(lastMens.isFinished())
                        out.println("No tiene menstruaciones pendientes");
                    else
                        out.println("Última menstruacion: "+lastMens.getStartDay().toString());
                }
                else
                    out.println("No tiene menstruaciones registradas");
                out.println("</h4>");
            %>
            
            <div class="divMenu">
                
                
            </div>
        </div>
        
    </body>
</html>
