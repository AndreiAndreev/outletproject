package ru.outletproject.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedUser extends BaseUser {

    @NotEmpty
    @Column(name = "name", nullable = false)
    protected String name;

    public NamedUser(){
    }

    protected NamedUser(Integer id, String name){
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
