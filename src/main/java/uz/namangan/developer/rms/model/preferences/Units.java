package uz.namangan.developer.rms.model.preferences;



import uz.namangan.developer.rms.model.audit.DateAudit;

import javax.persistence.*;

@Entity
@Table(name="units")
public class Units extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unit_name;
    private String short_name;
    private int base_unit;
    private String operator;
    private double operation_value;
    private int is_active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public int getBase_unit() {
        return base_unit;
    }

    public void setBase_unit(int base_unit) {
        this.base_unit = base_unit;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getOperation_value() {
        return operation_value;
    }

    public void setOperation_value(double operation_value) {
        this.operation_value = operation_value;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }
}
