package uz.namangan.developer.rms.dto;


public class TableFloorDto {
    public int id;
    public String floorname;


    public TableFloorDto() {
    }

    public TableFloorDto(String floorname) {
        this.floorname = floorname;
    }

    public TableFloorDto(int id, String floorname) {
        this.id = id;
        this.floorname = floorname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFloorname() {
        return floorname;
    }

    public void setFloorname(String floorname) {
        this.floorname = floorname;
    }

    @Override
    public String toString() {
        return "TableFloorDto{" +
                "floorname='" + floorname + '\'' +
                '}';
    }
}
