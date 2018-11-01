package icmit.dad.laborators.lab5.gui.models;

import icmit.dad.laborators.lab5.domain.PhoneType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 Класс, отвечающий за реализацию логики работы приложения ("модель"
 в рамках концепции MVC модель-представление-контроллер)
 */
public class Lab5Model {
    
    public String getCurrentTime(){
        return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
    }

    public List<PhoneType> getPhoneType(){
        ArrayList<PhoneType> res = new ArrayList<>();
        PhoneType p1 = new PhoneType();
        p1.setId(1l);
        p1.setName("Домашний");
        PhoneType p2 = new PhoneType();
        p2.setId(2l);
        p2.setName("Мобильный");
        res.add(p1);
        res.add(p2);
        return res;
    }
}
