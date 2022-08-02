package uz.namangan.developer.rms.model.orders;



import uz.namangan.developer.rms.model.audit.DateAudit;
import uz.namangan.developer.rms.model.table.RestTable;
import uz.namangan.developer.rms.model.user.User;
import uz.namangan.developer.rms.model.user.Waiter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orders")

public class Orders extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "create_by")
    private User user;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestTable table;

    @ManyToOne
    @JoinColumn(name = "order_types_id")
    private OrderTypes orderTypes;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private Waiter waiter;

    private Long service_charge;
    private Long discount;
    private Long order_types_commission;
    private Date order_date;
    private Date startdatetime;
    private Date enddatetime;
    private Double order_qty;
    private Double order_total;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}