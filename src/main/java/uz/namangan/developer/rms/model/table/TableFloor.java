package uz.namangan.developer.rms.model.table;



import javax.persistence.*;


@Entity
@Table(name="tablefloor")
public class TableFloor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="floorid")
    private int id;
    private String floorname;

    public TableFloor() {
    }

    public TableFloor(int id) {
        this.id = id;
    }

    public TableFloor(String floorname) {
        this.floorname = floorname;
    }

    public TableFloor(int id, String floorname) {
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
}
