
/**
 *
 * @author Sandi Argote
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VistaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //Sesion activa
        try {
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

            //Cerrar sesion
            out.println("</table>");
            out.println("<form action = 'LogoutServlet' method='post'>");
            out.println("<inpu type='submit' value='Cerrar sesión'>");
            out.println("</form>");

            out.println("<a href='inicio.jsp'>Añadir alumno</a>");
            out.println("<h1>Lista de alumnos</h1>");

            List<Alumnos> list = AlumnosDAO.getAllAlumnos();

            out.print("<table border='1' width='100%'");
            out.print("<tr><th>Numero de control</th><th>Nombre</th><th>Curso</th><th>Semestre</th>"
                    + "<th>Editar</th><th>Eliminar</th></tr>");

            for (Alumnos e : list) {
                out.print("<tr><td>" + e.getNumeroControl() + "</td><td>" + e.getNombre() + "</td><td>" + e.getCurso() + "</td><td>" + e.getSemestre() + "</td>"
                        + "<td><a href='EditarServlet?NUMEROCONTROL=" + e.getNumeroControl() + "'>Editar</a></td>"
                        + "<td><a href='EliminarServlet?NUMEROCONTROL=" + e.getNumeroControl() + "'>Eliminar</a></td></tr>");
            }
            out.print("</table>");

            out.close();

        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
