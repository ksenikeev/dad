package ru.kpfu.icmit.server4.model;

import ru.kpfu.icmit.server4.model.soap.Content;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Nomenclature extends Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nomenclatureIdGenerator")
    @SequenceGenerator(name = "nomenclatureIdGenerator", sequenceName = "nomenclature_seq", allocationSize=1)
    Long id;

    private UUID uid;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    public Nomenclature() {
    }

    public Nomenclature(String name, Date createDate, Date modifyDate) {
        this.name = name;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //@XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@XmlElement
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    //@XmlElement
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    //@XmlElement
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
