package com.entites;

public enum Size {
    XS("XS"),
    X("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    XXXL("XXXL");

    private String description;

    Size(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
