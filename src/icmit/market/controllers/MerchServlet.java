package icmit.market.controllers;

import icmit.market.DbWork;

import javax.servlet.ServletException;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/merch")
public class MerchServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        Connection con = DbWork.getInstance();
        List<String> merchList = new ArrayList<String>();


           try{
                String sql = "select * from price";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String price = rs.getString("pricevalue");
                    String available = rs.getBoolean("available")?"Есть в наличии":"Нет в наличии";

                    merchList.add("id: "+id+", name: "+name + ", price: "+price);
                }

               request.setAttribute("merchList", merchList);
                request.getRequestDispatcher("merch.ftlh").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ServletException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }

    }
}
