package uz.namangan.developer.rms.model.orders;


import uz.namangan.developer.rms.model.audit.DateAudit;

import javax.persistence.*;

@Entity
@Table(name = "order_types")
public class OrderTypes extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private int commission;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}