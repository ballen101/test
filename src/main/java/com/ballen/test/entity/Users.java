package com.ballen.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
/*所有属性的get/set方法、equals、canEqual、hashCode、toString方法*/
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int uid;
    private  String uaccount;
    private String uname;
    private  String uorg;
    private  int cid;

    public Users() {
    }
    public Users(String uaccount,String uname,String uorg,int cid) {
        this.uaccount=uaccount;
        this.uname=uname;
        this.uorg=uorg;
        this.cid=cid;
    }
}
