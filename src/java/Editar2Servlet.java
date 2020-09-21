
/**
 *
 * @author Sandi Argote
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Editar2Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

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

        String numeroControl = request.getParameter("NUMEROCONTROL");
        String nombre = request.getParameter("NOMBRE");
        String curso = request.getParameter("CURSO");
        String semestre = request.getParameter("SEMESTRE");

        Alumnos e = new Alumnos();
        e.setNumeroControl(numeroControl);
        e.setNombre(nombre);
        e.setCurso(curso);
        e.setSemestre(semestre);

        int status = AlumnosDAO.update(e);
        if (status > 0) {
            response.sendRedirect("VistaServlet");
        } else {
            out.println("No se guardaron los cambios");
        }

        out.close();
    }
}
