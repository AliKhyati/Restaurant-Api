package projet.wcs.starter.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AuthRestaurantRequest {


    @Column(nullable = false)
    private String companyName;


    @Column(nullable = false, unique = true)
    private String siren;


    @Column(nullable = false, unique = true)
    private String kbis;

    @NotNull
    @Email
    @Length(min = 5, max = 50)
    private String email;

    @NotNull @Length(min = 5)
    private String password;

    @Column(nullable = false, length = 64)
    private String firstname;

    @Column(nullable = false, length = 64)
    private String lastname;

    @Column(nullable = false, length = 64)
    private String phone;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
