package projet.wcs.starter.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false, unique = true)
    private String siren;


    @Column(nullable = false, unique = true)
    private String kbis;

    @OneToMany(mappedBy = "restaurant")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Restaurant() {}

    public Restaurant(String name, String siren, String kbis) {
        this.name = name;
        this.siren = siren;
        this.kbis = kbis;
    }

}
