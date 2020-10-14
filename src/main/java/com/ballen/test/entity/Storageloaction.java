package com.ballen.test.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "storageloaction")
public class Storageloaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slid;
    private String slnum;
    private String slname;
    private String slsize;
    private int slstock;
    private int slavailable;
    private int slstorage;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Warehouse.class,optional=true)
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "whid")
    private Warehouse wh;
    public Storageloaction() {
    }
    public Storageloaction(String slnum,String slname, String slsize, int slstock, int slavailable, int slstorage,Warehouse wh) {
        this.slnum = slnum;
        this.slname=slname;
        this.slsize = slsize;
        this.slstock = slstock;
        this.slavailable = slavailable;
        this.slstorage = slstorage;
        this.wh = wh;
    }
    public String getSlnum() {
        return slnum;
    }

    public void setSlnum(String slnum) {
        this.slnum = slnum;
    }

    public String getSlname() {
        return slname;
    }

    public void setSlname(String slname) {
        this.slname = slname;
    }

    public String getSlsize() {
        return slsize;
    }

    public void setSlsize(String slsize) {
        this.slsize = slsize;
    }

    public int getSlstock() {
        return slstock;
    }

    public void setSlstock(int slstock) {
        this.slstock = slstock;
    }

    public int getSlavailable() {
        return slavailable;
    }

    public void setSlavailable(int slavailable) {
        this.slavailable = slavailable;
    }

    public int getSlstorage() {
        return slstorage;
    }

    public void setSlstorage(int slstorage) {
        this.slstorage = slstorage;
    }

    public Warehouse getWh() {
        return wh;
    }

    public void setWh(Warehouse wh) {
        this.wh = wh;
    }
}
