package ru.kpfu.icmit.server4.model;

import org.hibernate.annotations.Type;
import ru.kpfu.icmit.server4.model.soap.Content;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "request")
public class Request extends Content {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requestGenerator")
    @SequenceGenerator(name = "requestGenerator", sequenceName = "request_seq", allocationSize = 1)
    private Long id;

    @Type(type="pg-uuid")
    private UUID uid;

    @ManyToOne
    private Nomenclature nomenclature;

    @ManyToOne
    private Organization organization;

    @Column
    private Float priceOfProduct;

    @Column
    private Float countOfProduct;

    @Column
    private String unitCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    @Temporal(TemporalType.DATE)
    private Date dateOfPerformance;

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

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Float getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(Float priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public Float getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(Float countOfProduct) {
        this.countOfProduct = countOfProduct;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getDateOfPerformance() {
        return dateOfPerformance;
    }

    public void setDateOfPerformance(Date dateOfPerformance) {
        this.dateOfPerformance = dateOfPerformance;
    }
}