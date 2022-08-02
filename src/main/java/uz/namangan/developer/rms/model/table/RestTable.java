package uz.namangan.developer.rms.model.table;


import javax.persistence.*;

@Entity
@Table(name="rest_table")
public class RestTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tableid")
    private int id;
    private String tablename;
    private int personcapicity;
    private String tableicon;
    @ManyToOne
    @JoinColumn(name="floorid")
    private TableFloor floor;
    private int status;
    public RestTable() {
    }

    public RestTable(String tablename, int personcapicity, String tableicon, TableFloor floor, int status) {
        this.tablename = tablename;
        this.personcapicity = personcapicity;
        this.tableicon = tableicon;
        this.floor = floor;
        this.status = status;
    }

    public RestTable(int id, String tablename, int personcapicity, String tableicon, TableFloor floor, int status) {
        this.id = id;
        this.tablename = tablename;
        this.personcapicity = personcapicity;
        this.tableicon = tableicon;
        this.floor = floor;
        this.status = status;
    }

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

    public TableFloor getFloor() {
        return floor;
    }

    public void setFloor(TableFloor floor) {
        this.floor = floor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
