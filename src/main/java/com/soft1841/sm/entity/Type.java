package com.soft1841.sm.entity;

public class Type {
    private  Long id ;
    private  Long type_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType_name() {
        return type_name;
    }

    public void setType_name(Long type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type_name=" + type_name +
                '}';
    }
}

