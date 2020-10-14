package com.ballen.test.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "progresses")
public class Progresses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;
    private String pname;
    private int pprogress;

    public Progresses() {
    }

    public Progresses(String pname, int pprogress) {
        this.pname = pname;
        this.pprogress = pprogress;
    }

}
