package icmit.dad.laborators.lab9.domain;

import icmit.dad.laborators.lab9.annotations.Column;
import icmit.dad.laborators.lab9.annotations.Table;

@Table(name = "contact", generator = "contact_seq")
public class Contact extends Entity {

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "inblacklist")
    private boolean inBlackList;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isInBlackList() {
        return inBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        this.inBlackList = inBlackList;
    }

    @Override
    public String toString(){
        return id + ": "+fullName;
    }

}
