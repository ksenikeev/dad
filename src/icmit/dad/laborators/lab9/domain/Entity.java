package icmit.dad.laborators.lab9.domain;

import icmit.dad.laborators.lab9.annotations.Column;
import icmit.dad.laborators.lab9.annotations.Id;

public abstract class Entity {

    @Id
    @Column(name = "id")
    protected Long id;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
