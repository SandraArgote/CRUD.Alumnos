<%-- 
    Document   : inicio
    Created on : 20/09/2020, 05:46:03 PM
    Author     : Sandi Argote
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <%
            if (session != null) {
                if (session.getAttribute("user") != null) {
                    String name = (String) session.getAttribute("user");
                    //out.print("Hello, " + name + "  Welcome to ur Profile");
                } else {
                    response.sendRedirect("index.jsp");
                }
            }
        %>

        <!-- CERRAR SESIÓN-->
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Cerrar sesion">
        </form>

        <h1>Añadir nuevo alumno</h1>        
        <form action="GuardarServlet" method="post">  
            <table>  
                <tr><td>Numero de control:</td><td><input type="text" name="NUMEROCONTROL"/></td></tr>  
                <tr><td>Nombre:</td><td><input type="text" name="NOMBREALUMNO"/></td></tr>  
                <tr><td>Curso:</td><td><input type="text" name="CURSO"/></td></tr>  
                <tr><td>Semestre:</td><td><input type="text" name="SEMESTRE"/></td></tr>  
                <tr><td colspan="2"><input type="submit" value="Guardar Alumno"/></td></tr>  
            </table>  
        </form>  
        <br/>  
        <a href="VistaServlet">Ver almunos</a> 
    </body>
</html>
