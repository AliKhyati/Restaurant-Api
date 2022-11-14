package projet.wcs.starter.dto;

import jakarta.validation.constraints.NotNull;

public class RestaurantTableDto {
    private Integer id;
    @NotNull
    private Integer number;
    @NotNull
    private Integer capacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
