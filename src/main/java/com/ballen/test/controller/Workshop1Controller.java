package com.ballen.test.controller;

import com.ballen.test.dto.ResultVO;
import com.ballen.test.entity.Workshop;
import com.ballen.test.mapper.WorkshopMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("workshop")
public class Workshop1Controller {
    @Autowired
    private WorkshopMapper wsMapper;

    @GetMapping("/getWorkshop")
    public ResultVO<List<Workshop>> getWorkshop() {
        List wsList = wsMapper.selectWorkshop();
        return ResultVO.success(wsList);
    }

    @GetMapping("/getWsum")
    public ResultVO<Integer> getWsum() {
        int wsum = wsMapper.sumWorkshop();
        return ResultVO.success(wsum);
    }
    @GetMapping("/getwcompletedToday")
    public ResultVO<Integer> getwcompletedToday(){
        int wcompletedToday=wsMapper.sumwWcompletedTday();
        return ResultVO.success(wcompletedToday);

    }
}