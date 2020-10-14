package com.ballen.test.controller;

import com.ballen.test.dto.ResultVO;
import com.ballen.test.entity.Progresses;
import com.ballen.test.mapper.ProgressesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("progresses")
public class ProgressesController {
    @Autowired
    private ProgressesMapper pMapper;
    @GetMapping("/getPrrogresses")
    public ResultVO<List<Progresses>> getPrrogresses(){
        List<Progresses> pList=pMapper.selectProgresses();
        return ResultVO.success(pList);
    }

}
