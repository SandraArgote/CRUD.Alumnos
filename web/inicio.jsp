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
            Cookie[] cks = request.getCookies();
            if (cks != null) {
                for (int i = 0; i < cks.length; i++) {
                    String name = cks[i].getName();
                    String value = cks[i].getValue();
                    if (name.equals("auth")) {
                        break;
                    }
                    if (i == (cks.length - 1)) {
                        response.sendRedirect("index.jsp");
                        return;
                    }
                    i++;
                }
            } else {
                response.sendRedirect("index.jsp");
                return;
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
