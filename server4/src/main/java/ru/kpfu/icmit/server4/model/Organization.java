package ru.kpfu.icmit.server4.model;

import ru.kpfu.icmit.server4.model.soap.Content;

import javax.persistence.*;

@Entity
public class Organization extends Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationIdGenerator")
    @SequenceGenerator(name = "organizationIdGenerator", sequenceName = "organization_seq", allocationSize=1)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
