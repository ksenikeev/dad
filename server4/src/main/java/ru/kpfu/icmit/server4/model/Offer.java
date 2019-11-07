package ru.kpfu.icmit.server4.model;

import ru.kpfu.icmit.server4.model.soap.Content;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Offer extends Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contractIdGenerator")
    @SequenceGenerator(name = "offerIdGenerator", sequenceName = "contract_seq", allocationSize=1)
    Long id;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    private Nomenclature nomenclature;

    private double priceOfProduct;

    private int countOfProduct;

    private String unitOfProduct;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfExpiration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public int getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(int countOfProduct) {
        this.countOfProduct = countOfProduct;
    }

    public String getUnitOfProduct() {
        return unitOfProduct;
    }

    public void setUnitOfProduct(String unitOfProduct) {
        this.unitOfProduct = unitOfProduct;
    }

    public Date getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Date dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }
}
