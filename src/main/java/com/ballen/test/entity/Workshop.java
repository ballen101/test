package com.ballen.test.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="workshop")
@Data
/*所有属性的get/set方法、equals、canEqual、hashCode、toString方法*/
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wid;
    private String wline;
    private int wnum;
    private int worder;
    private String wname;
    private  int wamount;
    private int wcumulative_complete;
    private int wcompleted_today;
    private String wschedule;
    private int wstate;

    public Workshop() {
    }
    public Workshop(String wline, int wnum, int worder, String wname, int wamount, int wcumulative_complete, int wcompleted_today, String wschedule, int wstate) {
        this.wline = wline;
        this.wnum = wnum;
        this.worder = worder;
        this.wname = wname;
        this.wamount = wamount;
        this.wcumulative_complete = wcumulative_complete;
        this.wcompleted_today = wcompleted_today;
        this.wschedule = wschedule;
        this.wstate = wstate;
    }

}
