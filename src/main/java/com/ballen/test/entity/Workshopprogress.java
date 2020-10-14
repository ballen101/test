package com.ballen.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
/*所有属性的get/set方法、equals、canEqual、hashCode、toString方法*/
@Entity
@Table(name="workshopprogress")
public class Workshopprogress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wsid;
    private String wsline;
    private String wsorder;
    private String wsprid;
    private String wsprname;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date wsprtime;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date wsstartime;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date wsendtime;
    private String wsprogress;
    private int wsstate;
    public Workshopprogress() {
    }
    public Workshopprogress(String wsline, String wsorder, String wsprid, String wsprname, Date wsprtime, Date wsstartime, Date wsendtime, String wsprogress,int wsstate) {
        this.wsline = wsline;
        this.wsorder = wsorder;
        this.wsprid = wsprid;
        this.wsprname = wsprname;
        this.wsprtime = wsprtime;
        this.wsstartime = wsstartime;
        this.wsendtime = wsendtime;
        this.wsprogress = wsprogress;
        this.wsstate=wsstate;
    }
}
