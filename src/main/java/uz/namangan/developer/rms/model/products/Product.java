package uz.namangan.developer.rms.model.products;



import uz.namangan.developer.rms.model.preferences.Suppliers;
import uz.namangan.developer.rms.model.preferences.Units;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "unit")
    private Units unit;

    private int alertqty;
    private String photo;
    private String photothumb;

    @ManyToOne
    @JoinColumn(name="suppiler")
    private Suppliers suppliers;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
