package ru.outletproject.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedRestaurant extends BaseRestaurant{

    @NotEmpty
    @Column(name = "name", nullable = false)
    protected String name;

    public NamedRestaurant(){
    }

    protected NamedRestaurant(Integer id, String name){
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedUser{" +
                "name='" + name + '\'' +
                '}';
    }
}
