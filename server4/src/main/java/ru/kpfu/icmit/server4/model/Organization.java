package ru.kpfu.icmit.server4.model;

import org.hibernate.annotations.Type;
import ru.kpfu.icmit.server4.model.soap.Content;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "organization")
public class Organization extends Content {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationGenerator")
    @SequenceGenerator(name = "organizationGenerator", sequenceName = "organization_seq", allocationSize = 1)
    private Long id;

    @Type(type="pg-uuid")
    private UUID uid;

    private String nameOfOrganization;

    private String adressOfOrganization;

    private String inn;

    private String kpp;

    private String ogrn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }

    public String getAdressOfOrganization() {
        return adressOfOrganization;
    }

    public void setAdressOfOrganization(String adressOfOrganization) {
        this.adressOfOrganization = adressOfOrganization;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }
}