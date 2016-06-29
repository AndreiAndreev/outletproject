package ru.outletproject.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "name"}, name = "restaurants_unique_idx_id_name")})
public class Restaurant extends NamedEntity{

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "restaurant")
    protected List<Dish> menu;

    @Column(name = "votes", nullable = false)
    @NotEmpty
    protected AtomicInteger votes;


    public Restaurant(){
    }

    public Restaurant(Restaurant r){
        this(r.getId(), r.getName(), r.getMenu());
    }

    public Restaurant(String name, List<Dish> menu){
        this(null, name,  menu);
    }

    public Restaurant(Integer id, String name, List<Dish> menu) {
        super(id, name);
        this.menu = menu;
        this.votes = new AtomicInteger(0);
    }

    public AtomicInteger getVotes() {
        return votes;
    }

    public void setVotes(AtomicInteger votes) {
        this.votes = votes;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "User (" +
                "id=" + id +
                ", name=" + name +
                ", menu=" + menu +
                ", votes=" + votes +
                ')';
    }
}
