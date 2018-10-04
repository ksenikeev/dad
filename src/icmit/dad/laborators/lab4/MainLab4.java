package icmit.dad.laborators.lab4;

import icmit.dad.laborators.lab4.dao.PhoneTypeDAO;
import icmit.dad.laborators.lab4.domain.PhoneType;
import icmit.dad.laborators.lab4.util.DbWork;

import java.sql.*;
import java.util.List;

public class MainLab4 {

    public static void main(String[] args) throws SQLException {
        DbWork db = DbWork.getInstance();

        PhoneTypeDAO phoneTypeDAO = new PhoneTypeDAO();

        List<PhoneType> lst = phoneTypeDAO.getAll();

        for ( PhoneType p : lst){
            System.out.println(p);
        }

        db.close();
    }
}
