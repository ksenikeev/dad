package icmit.dad.laborators.lab1.homework;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final String LINE = "+--------------+---------------+";
    public static final int WIDTH = 31;
    public static final int  HALF_WIDTH = 15;

    public static void main(String[] args) throws SQLException {
        Map<String, Abonent> abonents = null;
        DBWork dbWork = DBWork.getInstance();
        try (Statement statement = dbWork.getConnection().createStatement()) {
            String query = "select contact.fullname, phone.phonenumber, dict_phonetype.name from contact \n" +
                    "\tjoin phone on contact.id = phone.contact_id \n" +
                    "\tjoin dict_phonetype on dict_phonetype.id = phonetype_id;";
            ResultSet resultSet = statement.executeQuery(query);
            abonents = getAbonentsMap(resultSet);
            printAbonents(abonents);
        }
    }

    private static Map<String, Abonent> getAbonentsMap(ResultSet resultSet) throws SQLException {
        Map<String,Abonent> abonents = new HashMap<>();
        while(resultSet.next()){
            String fullname = resultSet.getString("fullname");
            Abonent a = abonents.get(fullname);
            if(a==null) {
                a = new Abonent(fullname);
            }
            a.add(new Phone(resultSet.getString("phonenumber"),
                    Phone.getTypeByString(resultSet.getString("name"))));
            abonents.put(fullname,a);
        }
        return abonents;
    }

    private static void printAbonents(Map<String, Abonent> abonents) {
        for(Map.Entry<String,Abonent> enty: abonents.entrySet()){
            System.out.println(LINE);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("| Абонент ");
            addSpaces(stringBuilder,WIDTH);
            System.out.println(stringBuilder.toString());
            System.out.println(LINE);
            stringBuilder = new StringBuilder("| ");
            stringBuilder.append(enty.getKey());
            addSpaces(stringBuilder,WIDTH);
            System.out.println(stringBuilder.toString());
            System.out.println(LINE);
            stringBuilder = new StringBuilder("| Номер ");
            addSpaces(stringBuilder,HALF_WIDTH);
            stringBuilder.append(" тип ");
            addSpaces(stringBuilder, WIDTH);
            System.out.println(stringBuilder.toString());
            System.out.println(LINE);
            for(Phone phone :  enty.getValue().getPhones()){
                stringBuilder = new StringBuilder("| ");
                stringBuilder.append(phone.getNumber());
                addSpaces(stringBuilder, HALF_WIDTH);
                stringBuilder.append(" ");
                stringBuilder.append(Phone.getStringByType(phone.getType()));
                addSpaces(stringBuilder,WIDTH);
                System.out.println(stringBuilder.toString());
                System.out.println(LINE);
            }
            System.out.println();
        }
    }

    private static void addSpaces(StringBuilder stringBuilder, int WIDTH) {
        while (stringBuilder.length() < WIDTH){
            stringBuilder.append(" ");
        }
        stringBuilder.append("|");
    }

}
