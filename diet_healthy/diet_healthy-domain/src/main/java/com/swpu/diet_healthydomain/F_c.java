package com.swpu.diet_healthydomain;

public class F_c {
    private Integer id;
    private Integer food_id;
    private Integer cook_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public Integer getCook_id() {
        return cook_id;
    }

    public void setCook_id(Integer cook_id) {
        this.cook_id = cook_id;
    }

    @Override
    public String toString() {
        return "F_c{" +
                "id=" + id +
                ", food_id=" + food_id +
                ", cook_id=" + cook_id +
                '}';
    }
}
