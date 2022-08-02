package uz.namangan.developer.rms.model.food;

import javax.persistence.*;

@Entity
@Table(name = "addons_list")
public class AddonsList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Add_ons_name;
    private String Price;
    private String Status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdd_ons_name() {
        return Add_ons_name;
    }

    public void setAdd_ons_name(String add_ons_name) {
        Add_ons_name = add_ons_name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
