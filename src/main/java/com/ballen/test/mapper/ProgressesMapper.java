package com.ballen.test.mapper;

import com.ballen.test.entity.Progresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressesMapper extends JpaRepository<Progresses,Integer> {
//   查询工序表的全部信息
    @Query(value = "select p from Progresses p")
    List<Progresses> selectProgresses();
}
