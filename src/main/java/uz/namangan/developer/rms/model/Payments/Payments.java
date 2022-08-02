package uz.namangan.developer.rms.model.Payments;



import uz.namangan.developer.rms.model.audit.DateAudit;
import uz.namangan.developer.rms.model.preferences.PaymentMethods;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="payments")
public class Payments extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private float paid;

    @OneToOne
    private PaymentMethods paymentmethod;
    private int create_by;
    private int sale_id;
    private int waiter_id;



}
