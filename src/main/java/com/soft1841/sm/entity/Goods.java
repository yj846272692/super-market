package com.soft1841.sm.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Goods {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleLongProperty typeId = new SimpleLongProperty();
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleDoubleProperty price =new SimpleDoubleProperty();
    private final SimpleStringProperty piture = new SimpleStringProperty("");
    private final SimpleStringProperty description = new SimpleStringProperty("");

    public Goods() {
    }
}
