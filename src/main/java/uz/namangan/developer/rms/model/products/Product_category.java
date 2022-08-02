package uz.namangan.developer.rms.model.products;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_category")
public class Product_category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CategoryName;
    private String CategoryDate;
    private String CategoryPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryDate() {
        return CategoryDate;
    }

    public void setCategoryDate(String categoryDate) {
        CategoryDate = categoryDate;
    }

    public String getCategoryPrice() {
        return CategoryPrice;
    }

    public void setCategoryPrice(String categoryPrice) {
        CategoryPrice = categoryPrice;
    }
}
