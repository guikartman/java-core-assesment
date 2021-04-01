package com.entites;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Collection {

    private Long id;
    private String name;

    private int subCollectionId = 0;

    private Set<SubCollection> subCollections = new HashSet<>();

    public Collection() {
    }

    public Collection(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<SubCollection> getSubCollections() {
        return subCollections;
    }

    public int getSubCollectionId() {
        return subCollectionId;
    }

    public void setSubCollectionId(int subCollectionId) {
        this.subCollectionId = subCollectionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
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
        final StringBuilder sb = new StringBuilder("Collection{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", subCollections=").append(subCollections);
        sb.append('}');
        return sb.toString();
    }
}
