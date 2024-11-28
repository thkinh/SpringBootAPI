package com.example.spring_api.API.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "u_setting")
public class UserSetting {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "setting")
    private AppUser thisAppUser;
    private String language;
    private String notification;
    private String shared_data;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public AppUser getUser() {
        return thisAppUser;
    }
    public void setUser(AppUser user) {
        this.thisAppUser = user;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getNotification() {
        return notification;
    }
    public void setNotification(String notification) {
        this.notification = notification;
    }
    public String getShared_data() {
        return shared_data;
    }
    public void setShared_data(String shared_data) {
        this.shared_data = shared_data;
    }

}
