package projet.wcs.starter.models;

import projet.wcs.starter.dao.User;

import java.util.Set;

public class RegisterUserRequest extends User {
    private Set<String> role;

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
