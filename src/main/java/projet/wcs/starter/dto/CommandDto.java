package projet.wcs.starter.dto;

import jakarta.validation.constraints.NotNull;
import projet.wcs.starter.dao.Comment;

import java.util.List;

public class CommandDto {
    private int id;
    private int number = (int)Math.floor(Math.random()*(500-1+1)+1);
    @NotNull
    private Float total = 0f;
    @NotNull
    private String status = "Prise de commande";
    private List<ItemDto> items;
    private List<CommentDto> comments;

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

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
