package com.entites;

import java.math.BigDecimal;

public class TShirt extends Product {
    private Size size;
    private boolean isLong;
    private String color;
    private Character gender;

    public TShirt() {
        super();
    }

    public TShirt(Long id, String name, BigDecimal price, String description, Integer quantity, Image image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.image = image;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean getIsLong() {
        return isLong;
    }

    public void setIsLong(boolean aLong) {
        isLong = aLong;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public boolean isValidTwo() {
        boolean valid = true;

        if(this.getSize() == null) {
            valid = false;
        }

        if(this.getColor().isEmpty() || this.getColor().equals("")) {
            valid = false;
        }

        if(!this.getGender().equals('M') && !this.getGender().equals('F')) {
            valid = false;
        }

        return valid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pants {");
        sb.append("id=").append(getId());
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", price=").append(getPrice());
        sb.append(", description='").append(getDescription()).append('\'');
        sb.append(", quantity=").append(getQuantity());
        sb.append(", image=").append(getImage());
        sb.append(", color='").append(getColor()).append('\'');
        sb.append(", gender=").append(getGender());
        sb.append("size=").append(size);
        sb.append(", isLong=").append(isLong);
        sb.append('}');
        return sb.toString();
    }
}
