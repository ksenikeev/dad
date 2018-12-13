package icmit.market;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        response.setHeader("Content-Type", "text/html; charset=utf-8");
        try {
            PrintWriter pw = response.getWriter();
            pw.println("<html><head><meta charset=\"utf-8\"/></head><body>");
            pw.println("<h1>Добро пожаловать</h1>");
            pw.println("<h2>Ваша корзина:</h2>");

            pw.println("1. Товар1 <br/>");
            pw.println("2. Товар2 <br/>");
            pw.println("3. Товар3 <br/>");
            pw.println("4. Товар4 <br/>");
            pw.println("<a href='index.html'>Главная</a>");

            pw.println("</body></html>");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
