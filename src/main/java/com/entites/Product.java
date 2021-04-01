package com.entites;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Product {

    protected Long id;
    protected String name;
    protected BigDecimal price;
    protected String description;
    protected Integer quantity;
    protected Image image;

    private SubCollection subCollection;


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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public SubCollection getSubCollection() {
        return subCollection;
    }

    public void setSubCollection(SubCollection subCollection) {
        this.subCollection = subCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isValid() {
        boolean valid = true;
        if (this.getName().isEmpty() || this.getName().equals("")) {
            valid = false;
        }

        if (this.getPrice().longValue() <= 0l) {
            valid = false;
        }

        if (this.getSubCollection() == null ) {
            valid = false;
        }

        return valid;
    }
}
