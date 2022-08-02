package uz.namangan.developer.rms.model.food;

import javax.persistence.*;

@Entity
@Table(name = "food_availablity")
public class FoodAvailablity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String food_id;
    private String Available_day;
    private String Available_time;
    private int is_active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getAvailable_day() {
        return Available_day;
    }

    public void setAvailable_day(String available_day) {
        Available_day = available_day;
    }

    public String getAvailable_time() {
        return Available_time;
    }

    public void setAvailable_time(String available_time) {
        Available_time = available_time;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }
}
