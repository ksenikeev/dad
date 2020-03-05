package ru.kpfu.icmit.server4.model;

import org.hibernate.annotations.Type;
import ru.kpfu.icmit.server4.model.soap.Content;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "contract")
public class Contract extends Content{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contractGenerator")
    @SequenceGenerator(name = "contractGenerator", sequenceName = "contract_seq", allocationSize = 1)
    private Long id;

    @Type(type="pg-uuid")
    private UUID uid;

    @ManyToOne
    private Nomenclature nomenclature;

    @ManyToOne
    private Offer offer;

    @ManyToOne
    private Request request;

    /** Стоимость контракта */
    private Float cost;

    private Float count;

    /** Код единицы измерения */
    private String unitCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    /** Срок исполнения */
    @Temporal(TemporalType.DATE)
    private Date dateOfPerformance;

    /** Факт исполнения */
    private Boolean status;

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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getCount() {
        return count;
    }

    public void setCount(Float count) {
        this.count = count;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDateOfPerformance() {
        return dateOfPerformance;
    }

    public void setDateOfPerformance(Date dateOfPerformance) {
        this.dateOfPerformance = dateOfPerformance;
    }
}