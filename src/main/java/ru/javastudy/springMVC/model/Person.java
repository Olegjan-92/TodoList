package ru.javastudy.springMVC.model;


import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity(name = "todolist")
@Table(name = "todolist")
public class Person implements Serializable{

    private static final long serialVersionUID = -5527566248002296042L;
    @Id
    @Column(name = "ida")
    @SequenceGenerator(name="generate_sequence", sequenceName="generate_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generate_sequence")
    private Integer id;
    @Column(name = "Задание")
    private String task;
    @Column(name = "Статус")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
