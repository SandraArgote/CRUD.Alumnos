<%-- 
    Document   : index
    Created on : 9/09/2020, 12:04:34 PM
    Author     : Sandra Argote
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>CRUD Alumnos</title>  
    </head>  
    <body>  

        <h1>Añadir alumno</h1>  
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
