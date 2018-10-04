package icmit.dad.laborators.lab4.domain;

public class PhoneType extends Entity{
    private String name;
    private String fullName;
    private String code;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    @Override
    public String toString(){
        return id + ": " + name + ", " + fullName + ", " + code;
    }
}
