package com.ballen.test.mapper;

import com.ballen.test.entity.Workshopprogress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopprogressMapper extends JpaRepository<Workshopprogress,Integer> {
    /*查询信息*/
    @Query(value = "select wsp from Workshopprogress wsp")
    List<Workshopprogress> selectWorkshopprogress();

}
