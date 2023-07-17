package com.example.springdatabasicdemo.dtos;

public class SubGroupDto {
    private int id;
    private String name;

    public SubGroupDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SubGroupDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student { id=" + id + ", name=" + name + " }";
    }
}
