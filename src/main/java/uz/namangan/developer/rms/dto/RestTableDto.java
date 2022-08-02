package uz.namangan.developer.rms.dto;


import java.io.Serializable;

public class RestTableDto implements Serializable {
    private int id;
    private String tablename;
    private int personcapicity;
    private String tableicon;
    private int floor;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public int getPersoncapicity() {
        return personcapicity;
    }

    public void setPersoncapicity(int personcapicity) {
        this.personcapicity = personcapicity;
    }

    public String getTableicon() {
        return tableicon;
    }

    public void setTableicon(String tableicon) {
        this.tableicon = tableicon;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
