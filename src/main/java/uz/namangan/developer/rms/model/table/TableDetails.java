package uz.namangan.developer.rms.model.table;



import uz.namangan.developer.rms.model.customer.Customers;

import javax.persistence.*;

@Entity
@Table(name = "table_details")
public class TableDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    private RestTable table_id;

    @OneToOne
    private Customers customer_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}