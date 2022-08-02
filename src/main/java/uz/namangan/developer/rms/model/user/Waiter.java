package uz.namangan.developer.rms.model.user;


import uz.namangan.developer.rms.model.audit.DateAudit;

import javax.persistence.*;

@Entity
@Table(name = "waiters")
public class Waiter extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}