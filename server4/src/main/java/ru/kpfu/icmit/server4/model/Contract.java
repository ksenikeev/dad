package ru.kpfu.icmit.server4.model;

import ru.kpfu.icmit.server4.model.soap.Content;
import javax.persistence.*;

@Entity
public class Contract extends Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contractIdGenerator")
    @SequenceGenerator(name = "contractIdGenerator", sequenceName = "contract_seq", allocationSize=1)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
