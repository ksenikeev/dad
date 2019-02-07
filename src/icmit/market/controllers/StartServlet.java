package icmit.market.controllers;

import icmit.market.DbWork;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;

@WebServlet(value = "/start", loadOnStartup = 1)
public class StartServlet extends HttpServlet{

    @Override
    public void init(){
        Connection con = DbWork.getInstance();
    }

    @Override
    public void destroy(){
        DbWork.close();
    }
}
