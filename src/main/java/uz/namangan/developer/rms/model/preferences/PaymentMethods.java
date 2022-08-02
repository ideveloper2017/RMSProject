package uz.namangan.developer.rms.model.preferences;

import uz.namangan.developer.rms.model.audit.DateAudit;

import javax.persistence.*;

@Entity
@Table(name="payment_methods")
public class PaymentMethods extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_methods_id")
    private Long id;
    private String	payment_method;
    private int status;


}
