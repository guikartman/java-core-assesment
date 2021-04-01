package com.entites;

import java.math.BigDecimal;

public class Sneakers extends Product{
    private Integer size;
    private String activity;

    public Sneakers(){
        super();
    }

    public Sneakers(Long id, String name, BigDecimal price, String description, Integer quantity, Image image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.image = image;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public boolean isValidTwo() {
        boolean valid = true;

        if(this.getSize() == null || this.getSize() <= 0) {
            valid = false;
        }

        if (this.getActivity().isEmpty() || this.getActivity().equals("")) {
            valid = false;
        }

        return valid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sneaker {");
        sb.append("id=").append(getId());
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", price=").append(getPrice());
        sb.append(", description='").append(getDescription()).append('\'');
        sb.append(", quantity=").append(getQuantity());
        sb.append(", color='").append(getColor()).append('\'');
        sb.append(", image=").append(getImage());
        sb.append(", gender=").append(getGender());
        sb.append(", size=").append(size);
        sb.append(", activity='").append(activity).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
