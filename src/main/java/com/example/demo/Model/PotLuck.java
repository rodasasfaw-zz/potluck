package com.example.demo.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class PotLuck{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(mappedBy = "potLucks")
    private Collection<AppUser> appUser;


    public PotLuck() {


    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<AppUser> getAppUser() {
        return appUser;
    }

    public void setAppUser(Collection<AppUser> appUser) {
        this.appUser = appUser;
    }


}
