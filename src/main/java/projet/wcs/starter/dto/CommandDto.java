package projet.wcs.starter.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CommandDto {
    private int id;
    private int number = (int)Math.floor(Math.random()*(500-1+1)+1);
    @NotNull
    private Float total = 0f;
    @NotNull
    private String status = "Prise de commande";
    private String comment;
    private List<ItemDto> items;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
