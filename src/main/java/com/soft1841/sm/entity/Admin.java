package com.soft1841.sm.entity;

public class Admin {
    private Long id ;
    private String name ;
    private String adminNumber ;

    public Admin() {
    }

    public Admin(Long id, String name, String adminNumber) {
        this.id = id;
        this.name = name;
        this.adminNumber = adminNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adminNumber='" + adminNumber + '\'' +
                '}';
    }
}
