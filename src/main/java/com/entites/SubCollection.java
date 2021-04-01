package com.entites;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SubCollection {
    private Long id;
    private String name;

    private Set<Product> products = new HashSet<>();

    public SubCollection(){
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

    public SubCollection(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCollection that = (SubCollection) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isValid() {
        boolean valid = true;
        if (name.isEmpty() || name.equals("")) {
            valid = false;
        }
        return valid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubCollection{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}
