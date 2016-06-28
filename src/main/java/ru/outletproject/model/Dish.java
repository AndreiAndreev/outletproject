package ru.outletproject.model;


public class Dish extends NamedEntity{

    private int price;


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

}
