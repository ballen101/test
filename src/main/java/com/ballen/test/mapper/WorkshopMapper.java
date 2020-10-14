package com.ballen.test.mapper;

import com.ballen.test.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopMapper extends JpaRepository<Workshop, Integer> {
    /*查询车间全部信息*/
    @Query(value = "select ws from Workshop ws")
    List<Workshop> selectWorkshop();
    /*查询全部人数*/
    @Query(value="select sum(ws.wnum) from Workshop ws")
    int sumWorkshop();
    /*查询当日总产出*/
    @Query(value = "select sum(ws.wcompleted_today) from Workshop ws")
    int sumwWcompletedTday();
}
