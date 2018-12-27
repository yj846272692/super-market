package com.soft1841.sm.entity;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 类别实体类
 * @author 杨晶
 */

public class Type {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleStringProperty typeName = new SimpleStringProperty("");

    public Type() {
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getTypeName() {
        return typeName.get();
    }

    public SimpleStringProperty typeNameProperty() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName.set(typeName);
    }

    @Override
    public String toString() {
        return  typeName.get();
    }
}
