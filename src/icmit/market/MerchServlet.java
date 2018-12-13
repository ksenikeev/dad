package icmit.market;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/merch")
public class MerchServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        Connection con = DbWork.getInstance();

        response.setHeader("Content-Type", "text/html; charset=utf-8");
        try {
            PrintWriter pw = response.getWriter();
            pw.println("<html><head><meta charset=\"utf-8\"/></head><body>");
            pw.println("<h1>Добро пожаловать</h1>");
            pw.println("<h2>Наши товары</h2>");

            try{
                String sql = "select * from price";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String price = rs.getString("pricevalue");
                    String available = rs.getBoolean("available")?"Есть в наличии":"Нет в наличии";
                    pw.println(id +", "+name+", "+price+", "+available+"<br/>");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            pw.println("<a href='index.html'>Главная</a>");

            pw.println("</body></html>");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
