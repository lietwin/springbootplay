package io.ar.metechium.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class VeggieBucket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Vegetable> vegetables;

    public VeggieBucket() {
    }

    public VeggieBucket(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }


    @Override
    public String toString() {
        return "VeggieBucket{" +
                "id=" + id +
                ", vegetables=" + vegetables +
                '}';
    }
}
