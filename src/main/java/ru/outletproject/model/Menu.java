package ru.outletproject.model;

import java.time.LocalDateTime;
import java.util.List;


public class Menu extends BaseEntity{

    protected List<Dish> dishes;

    private LocalDateTime dateTime;


    public Menu(){
    }

    public Menu(LocalDateTime dateTime, List<Dish> dishes){
        this(null, dateTime, dishes);
    }

    public Menu(Integer id, LocalDateTime dateTime, List<Dish> dishes) {
        super(id);
        this.dateTime = dateTime;
        this.dishes = dishes;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Dish> getDish() {

        return dishes;
    }

    public void setDish(List<Dish> dish) {
        this.dishes = dish;
    }

    @Override
    public String toString() {
        return "User (" +
                "id=" + id +
                ", dishes=" + dishes +
                ", dateTime=" + dateTime +
                ')';
    }
}
