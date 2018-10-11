package icmit.dad.laborators.lab12;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NextStepServlet  extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException,
            IOException
    {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Следующий шаг (NextStepServlet)</h1>");
        response.getWriter().println("<h1><a href='hello'>Назад <a></h1>");
    }

}
