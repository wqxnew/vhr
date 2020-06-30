package com.javamm.vhr.model;

import java.util.List;

public class ResPageBean {
    private Long tatol;
    private List<?> data;

    public Long getTatol() {
        return tatol;
    }

    public void setTatol(Long tatol) {
        this.tatol = tatol;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
