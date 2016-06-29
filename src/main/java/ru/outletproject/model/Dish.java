package ru.outletproject.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Table(name = "restaurants_dishes")
public class Dish extends NamedEntity{

    @Column(name = "price")
    @NotNull
    @Range(min = 10, max = 5000)
    protected int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    protected Restaurant restaurant;


    public Dish(){}

    public Dish(Integer id, String name, int price) {
        super(id, name);
        this.price = price;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "User (" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ')';
    }
}
