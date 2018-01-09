package com.cargain.micro.landscape.LandscapePrivateService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    private String organization;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<UserLog> usersLogs;

    public List<UserLog> getUsersLogs() {
        return usersLogs;
    }

    public void setUsersLogs(List<UserLog> usersLogs) {
        this.usersLogs = usersLogs;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
   

    public String getOrganization() {
        return organization;
    }

    public User setOrganization(String organization) {
        this.organization = organization;
        return this;
    }
}
