package com.pandatv.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Yuan on 2017/9/22.
 */

@Entity
public class UserBean implements Serializable {
    static final long serialVersionUID =536871008L;
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "sname")
    private String username;
    @Property(nameInDb = "spwd")
    private String password;
    @Generated(hash = 2052951463)
    public UserBean(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}