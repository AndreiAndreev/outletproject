package ru.outletproject.model;


public class Dish extends NamedEntity{

    protected int price;


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

    @Override
    public String toString() {
        return "User (" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ')';
    }
}
