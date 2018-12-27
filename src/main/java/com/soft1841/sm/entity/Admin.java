package com.soft1841.sm.entity;

/**
 * 管理员实体类
 * @author 杨晶
 */

public class Admin {
    private Long id ;
    private String name ;
    private String adminNumber ;
    private String password;

    public Admin() {
    }

    public Admin(Long id, String name, String adminNumber, String password) {
        this.id = id;
        this.name = name;
        this.adminNumber = adminNumber;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adminNumber='" + adminNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
