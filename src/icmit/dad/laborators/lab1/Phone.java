package icmit.dad.laborators.lab1;

public class Phone {

    public static final String WORK = "Рабочий";
    public static final String HOME = "Домашний";
    public static final String MOBILE = "Мобильный";

    private String number;
    private PhoneType type;

    public Phone(String number, PhoneType type) {
        this.number = number;
        this.type = type;
    }

    public static PhoneType getTypeByString(String name) {
        switch (name) {
            case Phone.HOME: return PhoneType.HOME;
            case Phone.MOBILE: return PhoneType.MOBILE;
            case Phone.WORK: return PhoneType.WORK;
        }
        System.out.println("---------------------------------------------");
        System.err.println("error");
        return null;
    }

    public static String getStringByType(PhoneType type) {
        switch (type){
            case HOME: return Phone.HOME;
            case WORK: return Phone.WORK;
            case MOBILE: return Phone.MOBILE;
        }
        System.err.println("error");
        return null;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }
}
