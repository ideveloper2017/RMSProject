package uz.namangan.developer.rms.model.orders;



import uz.namangan.developer.rms.model.audit.DateAudit;
import uz.namangan.developer.rms.model.products.Product;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_items")
public class OrderItems extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Orders order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product product;
    private float qty;
    private float price;
    private float subtotal;
    private Date date;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}