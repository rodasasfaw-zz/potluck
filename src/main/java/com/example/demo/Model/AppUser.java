package com.example.demo.Model;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String username;


    @Column
    private String password;

    @ManyToMany(fetch =FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Collection<Role> roles;

    @ManyToMany(mappedBy = "appUserSet")
    private Set<PledgedItem> pledgedItemList;
    @ManyToMany
    private Set<PotLuck> potLucks;

    public AppUser() {
        this.potLucks = new HashSet<PotLuck>();
        this.pledgedItemList = new HashSet<PledgedItem>();
    }


    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Set<PledgedItem> getPledgedItemList() {
        return pledgedItemList;
    }

    public void setPledgedItemList(Set<PledgedItem> pledgedItemList) {
        this.pledgedItemList = pledgedItemList;
    }

public void additem(PledgedItem p){
        this.pledgedItemList.add(p);
}
}

