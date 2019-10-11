package icmit.dad.group652.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

public class Nomenclature {
    
    private UUID uuid;
    private String productName;
    private Date firstDate;
    private Date changeDate;
    private String metric;
    private Boolean status;

    public Nomenclature(String productName, String metric) {
        this.uuid = UUID.randomUUID();
        this.firstDate = Date.valueOf(LocalDate.now());
        this.changeDate = Date.valueOf(LocalDate.now());
        this.productName = productName;
        this.metric = metric;
        this.status = true;
    }

    public Nomenclature() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Nomenclature(UUID uuid, String productName, Date firstDate, Date changeDate, String metric, Boolean status) {
        this.uuid = uuid;
        this.productName = productName;
        this.firstDate = firstDate;
        this.changeDate = changeDate;
        this.metric = metric;
        this.status = status;
    }
}
