package uz.namangan.developer.rms.model.menu;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menu_type")
public class MenuType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menutypeid;
    private String menutype;
    private String menu_icon;
    private int status;

    public Long getMenutypeid() {
        return menutypeid;
    }

    public void setMenutypeid(Long menutypeid) {
        this.menutypeid = menutypeid;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
