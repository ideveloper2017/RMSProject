package uz.namangan.developer.rms.model.commission;

import javax.persistence.*;

@Entity
@Table(name = "payroll_commission")
public class PayrollCommission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}