package ru.outletproject.to;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class RestaurantTo implements Serializable {
    private static final long serialVersionUID = 1L;

    protected int id;

    @NotEmpty
    protected String name;

    @NotEmpty
    @Size(min = 5, max = 100000)
    protected Integer votes;

    public RestaurantTo() {
    }

    public RestaurantTo(int id, String name, Integer votes) {
        this.id = id;
        this.name = name;
        this.votes = votes;
    }

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

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }
}
