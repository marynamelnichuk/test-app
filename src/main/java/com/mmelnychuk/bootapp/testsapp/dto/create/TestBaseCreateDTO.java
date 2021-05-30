package com.mmelnychuk.bootapp.testsapp.dto.create;

import com.mmelnychuk.bootapp.testsapp.dto.DTO;

public class TestBaseCreateDTO implements DTO {

    private String name;
    private String category;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
