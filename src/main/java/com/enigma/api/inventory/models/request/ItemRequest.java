package com.enigma.api.inventory.models.request;

import com.enigma.api.inventory.models.validations.Alphabetic;

public class ItemRequest {

    @Alphabetic
    private String name;

    private Integer price;

    private Integer unitId;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }
}
