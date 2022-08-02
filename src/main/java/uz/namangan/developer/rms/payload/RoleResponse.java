package uz.namangan.developer.rms.payload;

public class RoleResponse {
    private Long roleid;
    private String name;

    public RoleResponse(){

    }

    public RoleResponse(Long roleid, String name) {
        this.roleid = roleid;
        this.name = name;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
