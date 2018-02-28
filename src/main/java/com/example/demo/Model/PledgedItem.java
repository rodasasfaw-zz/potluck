package com.example.demo.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PledgedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String itemType;
    private int servingSize;
    @ManyToMany
    private Collection<AppUser> appUserSet;

    public PledgedItem() {
        this.appUserSet = new HashSet<>();
    }

    public PledgedItem(String name, String itemType, int servingSize) {
        this.name = name;
        this.itemType = itemType;
        this.servingSize = servingSize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public Collection<AppUser> getAppUserSet() {
        return appUserSet;
    }

    public void setAppUserSet(Set<AppUser> appUserSet) {
        this.appUserSet = appUserSet;
    }



}
