package it.vincenzocorso;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Task extends PanacheEntity {
    public String title;
    public String content;

    public Task() {
    }

    public Task(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
