package ru.outletproject.model;


import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant extends NamedEntity{

    protected Menu menu;

    protected AtomicInteger votes;


    public Restaurant(){
    }

    public Restaurant(Restaurant r){
        this(r.getId(), r.getName(), r.getMenu());
    }

    public Restaurant(String name, Menu menu){
        this(null, name, menu);
    }

    public Restaurant(Integer id, String name, Menu menu) {
        super(id, name);
        this.menu = menu;
        this.votes = new AtomicInteger(0);
    }


    public AtomicInteger getVotes() {
        return votes;
    }

    public int vote() {
        return votes.incrementAndGet();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
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
