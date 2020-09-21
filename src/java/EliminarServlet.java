
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

public class EliminarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

            String numeroControl = request.getParameter("NUMEROCONTROL");
            AlumnosDAO.delete(numeroControl);
            response.sendRedirect("VistaServlet");

        } catch (Exception exc) {
            System.out.println(exc);
        }

    }
}
