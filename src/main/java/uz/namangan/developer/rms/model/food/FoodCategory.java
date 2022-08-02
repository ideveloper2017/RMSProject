package uz.namangan.developer.rms.model.food;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "food_category")
public class FoodCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int position;
    private String image;
    private String category_name;
    private int parent_Id;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(int parent_Id) {
        this.parent_Id = parent_Id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
