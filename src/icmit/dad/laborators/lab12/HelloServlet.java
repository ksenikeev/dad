package icmit.dad.laborators.lab12;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    @Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException,
            IOException
    {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Добро пожаловать! (HelloServlet)</h1>");
        response.getWriter().println("<h1><a href='next'>Продолжить </a></h1>");
        response.getWriter().println("<h1><form enctype='text/plain' method='post' action='next'>");
        response.getWriter().println("Name <input type='text' name='nameparam'/>");
        response.getWriter().println("<input type='submit' name='nameparam1'/>");
        response.getWriter().println("</form></h1>");
        response.getWriter().println("<h1><form enctype='application/x-www-form-urlencoded' method='post' action='next'>");
        response.getWriter().println("Name <input type='text' name='nameparam'/>");
        response.getWriter().println("<input type='submit' name='nameparam'/>");
        response.getWriter().println("</form></h1>");
        response.getWriter().println("<h1><form enctype='multipart/form-data' method='post' action='next'/>");
        response.getWriter().println("<p>Загрузите файл с картинкой</p>");
        response.getWriter().println("<p><input type='file' name='pic'/></p>");
        response.getWriter().println("<input type='submit' name='nameparam'/>");
        response.getWriter().println("</form></h1>");
    }
}