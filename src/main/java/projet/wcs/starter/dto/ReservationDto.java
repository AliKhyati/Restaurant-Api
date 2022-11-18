package projet.wcs.starter.dto;

import java.util.Date;

public class ReservationDto {
    private int id;
    private String clientName;
    private Date date = new Date();
    private CommandDto command;
    private int restaurantTableId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CommandDto getCommand() {
        return command;
    }

    public void setCommand(CommandDto command) {
        this.command = command;
    }

    public int getRestaurantTableId() {
        return restaurantTableId;
    }

    public void setRestaurantTableId(int restaurantTableId) {
        this.restaurantTableId = restaurantTableId;
    }
}
