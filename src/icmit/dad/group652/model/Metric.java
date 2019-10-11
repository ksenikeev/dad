package icmit.dad.group652.model;

public class Metric {
    private Long id;
    private String code;
    private String metricName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public Metric(Long id, String code, String metricName) {
        this.id = id;
        this.code = code;
        this.metricName = metricName;
    }
}
