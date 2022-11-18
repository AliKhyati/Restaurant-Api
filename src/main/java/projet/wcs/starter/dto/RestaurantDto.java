package projet.wcs.starter.dto;

import java.util.List;

public class RestaurantDto {

    private int id;

    private String name;

    private String siren;

    private String kbis;

    private List<UserDto> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }

    public String getKbis() {
        return kbis;
    }

    public void setKbis(String kbis) {
        this.kbis = kbis;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
