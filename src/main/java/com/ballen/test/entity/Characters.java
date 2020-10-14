package com.ballen.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="characters")
@Data
/*所有属性的get/set方法、equals、canEqual、hashCode、toString方法*/
public class Characters  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int cid;
    private  String cname;
    private  String ccode;
    private Date cdate;
    private  String cman;
    private int cstate;

    public Characters() {
    }
    public Characters(String cname,String ccode,Date cdate,String cman,int cstate) {
        this.cname=cname;
        this.ccode=ccode;
        this.cdate=cdate;
        this.cman=cman;
        this.cstate=cstate;
    }

}
