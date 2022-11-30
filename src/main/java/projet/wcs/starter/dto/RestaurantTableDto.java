package projet.wcs.starter.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class RestaurantTableDto {
    private Integer id;

    @NotNull
    private Integer number;

    @NotNull
    private Integer capacity;

    private List<ReservationDto> reservations;

    public List<ReservationDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }

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
