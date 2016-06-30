package ru.outletproject.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

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
    @Range(min = 5,max = 100000)
    protected Integer votes = 0;


    public Restaurant(){
    }

    public Restaurant(Restaurant r){
        this(r.getId(), r.getName(), r.getMenu(), r.getVotes());
    }

    public Restaurant(String name, List<Dish> menu, Integer votes){
        this(null, name,  menu, votes);
    }

    public Restaurant(Integer id, String name, List<Dish> menu, Integer votes) {
        super(id, name);
        this.menu = menu;
        this.votes = votes;
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
