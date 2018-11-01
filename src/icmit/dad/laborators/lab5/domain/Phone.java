package icmit.dad.laborators.lab5.domain;

public class Phone extends Entity{

    private Contact contact;
    private PhoneType phoneType;
    private String phoneNumber;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return id + ": " + phoneNumber +", "+ (phoneType!=null?phoneType.getName():"[null]") +
                ", "+ (contact!=null?contact.getFullName():"[never man]");
    }
}
