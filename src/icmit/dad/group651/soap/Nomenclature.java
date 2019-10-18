package icmit.dad.group651.soap;

import icmit.dad.group651.soap.model.Content;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.UUID;

public class Nomenclature extends Content {

    private UUID uid;

    private String name;

    private Date createDate;

    private Date modifyDate;

    public Nomenclature() {
    }

    public Nomenclature(String name, Date createDate, Date modifyDate) {
        this.name = name;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @XmlElement
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @XmlElement
    public UUID getUid() {
        if (uid == null) {
             uid = UUID.randomUUID();
        }
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Nomenclature{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
