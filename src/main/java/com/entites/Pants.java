package com.entites;

import java.math.BigDecimal;

public class Pants extends Product{
    private Size size;
    private String activity;
    private String material;

    public Pants(){
    }

    public Pants(Long id, String name, BigDecimal price, String description, Integer quantity, Image image) {
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

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isValidTwo() {
        boolean valid = true;

        if(this.getSize() == null) {
            valid = false;
        }

        if (this.getActivity().isEmpty() || this.getActivity().equals("")) {
            valid = false;
        }

        if (this.getMaterial().isEmpty() || this.getMaterial().equals("")) {
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
        sb.append(", color='").append(getColor()).append('\'');
        sb.append(", image=").append(getImage());
        sb.append(", gender=").append(getGender());
        sb.append("size=").append(size);
        sb.append(", activity='").append(activity).append('\'');
        sb.append(", material='").append(material).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
