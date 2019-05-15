package com.train4game.munoon.domain;

import javax.persistence.*;

@Entity
@Table (name = "parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int count;
    private String name;
    private boolean need;

    public Part() {
    }

    public Part(String name, boolean need, int count) {
        this.name = name;
        this.need = need;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeed() {
        return need;
    }

    public String isNeedTranslated() {
        return need ? "Да" : "Нет";
    }

    public String checked() {
        return need ? "checked" : "";
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", need=" + need +
                ", count=" + count +
                '}';
    }
}
