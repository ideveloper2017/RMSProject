package uz.namangan.developer.rms.model.preferences;


import uz.namangan.developer.rms.model.audit.DateAudit;

import javax.persistence.*;

@Entity
@Table(name="suppliers")
public class Suppliers extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String note;





}
