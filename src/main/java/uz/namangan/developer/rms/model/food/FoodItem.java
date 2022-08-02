package uz.namangan.developer.rms.model.food;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "food_item")
public class FoodItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductsID;
    private int CategoryID;
    private String ProductName;
    private String ProductImage;
    private String component;
    private String descrip;
    private String itemnotes;
    private String menutype;
    private int OffersRate;
    private int kitchenid;

    public Long getProductsID() {
        return ProductsID;
    }

    public void setProductsID(Long productsID) {
        ProductsID = productsID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String productImage) {
        ProductImage = productImage;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getItemnotes() {
        return itemnotes;
    }

    public void setItemnotes(String itemnotes) {
        this.itemnotes = itemnotes;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public int getOffersRate() {
        return OffersRate;
    }

    public void setOffersRate(int offersRate) {
        OffersRate = offersRate;
    }

    public int getKitchenid() {
        return kitchenid;
    }

    public void setKitchenid(int kitchenid) {
        this.kitchenid = kitchenid;
    }
}
