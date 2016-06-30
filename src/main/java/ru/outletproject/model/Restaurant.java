package ru.outletproject.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "name"}, name = "restaurants_unique_idx_id_name")})
public class Restaurant extends NamedEntity{

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "restaurant")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    protected List<Dish> menu;

    @Column(name = "votes", nullable = false)
    @NotEmpty
    protected Integer votes;


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
        this.votes = 0;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
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
