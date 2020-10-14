package com.ballen.test.mapper;

import com.ballen.test.entity.Storageloaction;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageloactionMapper extends JpaRepository<Storageloaction,Integer> {
    /*查询全部*/
//    @Query(value = "select s.slid,s.slnum,s.slsize,s.slstock,s.slavailable,s.slstorage,w.whname from Storageloaction s ,Warehouse w where s.wh.whid=w.whid")
//    List<Storageloaction> selectStorageloaction();
    /*查询储位总数*/
    @Query(value = "select sum(s.slstorage) from Storageloaction s")
    int sumSlstorage();
    /*查询空闲储位*/
    @Query(value = "select 510-sum(s.slstorage) from Storageloaction s")
    int sumStockAvailable();
    @Query(value = "select (510.0-sum(s.slstorage))/5.1 from Storageloaction s")
    Double sumSlstoragerate();
    /*拣位*/
    @Query(value = "select count(s) from Storageloaction s where s.slavailable <> 0 ")
    int countSlpicking();
    @Query(value = "select * from Storageloaction s where s.slnum like CONCAT('%',:slnum,'%')",nativeQuery = true)
    List<Storageloaction> selectlikeStorageloaction(@Param("slnum") String slnum);
    //添加
//    @Query(value = "INSERT into storageloaction(slnum, slname,slsize,slstock,slavailable,slstorage,whid) value("11123","吹风机","中",5000,100,1,1")

    @Modifying
    @Query(value = "insert into storageloaction(slnum, slname,slsize,slstock,slavailable,slstorage,whid) value(?1,?2,?3,?4,?5,?6,?7)",nativeQuery=true)
    void insertStorageloaction(String slnum,String slname, String slsize, Integer slstock, Integer slavailable,Integer slstorage, Integer whid);
}
