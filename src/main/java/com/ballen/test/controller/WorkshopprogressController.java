package com.ballen.test.controller;

import com.ballen.test.dto.ResultVO;
import com.ballen.test.entity.Workshopprogress;
import com.ballen.test.mapper.WorkshopprogressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("workshopprogress")
public class WorkshopprogressController {
    @Autowired
    private WorkshopprogressMapper wspMapper;

    @GetMapping("/getWorkshopprogress")
    public ResultVO<List<Workshopprogress>> getWorkshopprogress(){
        List<Workshopprogress> wspList=wspMapper.selectWorkshopprogress();
        return ResultVO.success(wspList);
    }
}
