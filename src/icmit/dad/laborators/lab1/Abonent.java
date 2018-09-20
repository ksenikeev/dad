package icmit.dad.laborators.lab1;

import java.util.ArrayList;

public class Abonent {

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    private String fio;
    private ArrayList<Phone> phones;

    public ArrayList<Phone> getPhones() {
        return phones;
    }


    public Abonent(String fio) {
        this.fio = fio;
        this.phones = new ArrayList<>();
    }

    public void add(Phone phone){
        phones.add(phone);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Abonent)) return false;
        Abonent abonent = (Abonent) obj;
        return this.fio==abonent.getFio();
    }
}
