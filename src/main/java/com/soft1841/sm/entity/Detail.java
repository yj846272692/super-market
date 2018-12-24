package com.soft1841.sm.entity;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Set;

public class Detail {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleLongProperty cashierId = new SimpleLongProperty();
    private final SimpleStringProperty barcode = new SimpleStringProperty("");
    private final SimpleLongProperty amount = new SimpleLongProperty();

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public long getCashierId() {
        return cashierId.get();
    }

    public SimpleLongProperty cashierIdProperty() {
        return cashierId;
    }

    public void setCashierId(long cashierId) {
        this.cashierId.set(cashierId);
    }

    public String getBarcode() {
        return barcode.get();
    }

    public SimpleStringProperty barcodeProperty() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode.set(barcode);
    }

    public long getAmount() {
        return amount.get();
    }

    public SimpleLongProperty amountProperty() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount.set(amount);
    }

    public Detail(Long id, Long cashierId, String barcode, Long amount) {
        setId(id);
        setCashierId(cashierId);
        setBarcode(barcode);
        setAmount(amount);
    }
}
