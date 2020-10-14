package com.ballen.test.controller;

import com.ballen.test.dto.ResultVO;
import com.ballen.test.entity.Storageloaction;
import com.ballen.test.mapper.StorageloactionMapper;
import com.ballen.test.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.List;
@Transactional
@RestController
@RequestMapping("storageloaction")
public class StorageloactionController {
    @Autowired
    private StorageloactionMapper slMapper;

    @GetMapping("/getStorageloaction")
    public ResultVO<List<Storageloaction>> getStorageloaction() {
        List<Storageloaction> slList = slMapper.findAll();
        return ResultVO.success(slList);
    }

    //    更新
    @PostMapping("/updateStoragelocation")
    public ResultVO update(@RequestBody Storageloaction storage) {
        Storageloaction storageloaction = slMapper.saveAndFlush(storage);
        if (storageloaction != null) {
            return ResultVO.success();
        }
        return ResultVO.failed();
    }

    //    插入方法
    @PostMapping("/insertStoragelocation")
    public ResultVO insertStoragelocation(@RequestBody Storageloaction storage) {
        JSONUtils jo = new JSONUtils();
        storage.setSlname(jo.decode(storage.getSlname()));
        storage.setSlsize(jo.decode(storage.getSlsize()));
        slMapper.insertStorageloaction(storage.getSlnum(),storage.getSlname(),storage.getSlsize(),storage.getSlstock(),storage.getSlavailable(),storage.getSlstorage(),storage.getWh().getWhid());

        return ResultVO.success();

    }

    //    @PostMapping("/insertStoragelocation")
//    public ResultVO insertStoragelocation(@RequestBody Storageloaction storage){
//        JSONUtils jo=new JSONUtils();
//        storage.setSlname(jo.decode(storage.getSlname()));
//        storage.setSlsize(jo.decode(storage.getSlsize()));
//        Storageloaction storageloaction=slMapper.saveAndFlush(storage);
//        if(storageloaction!=null){
//            return ResultVO.success();
//        }
//        return ResultVO.failed();
//    }
    @GetMapping("/getSumSlstorage")
    public ResultVO<Integer> getSumSlstorage() {
        int sumSlstorage = slMapper.sumSlstorage();
        return ResultVO.success(sumSlstorage);
    }

    @GetMapping("/getSumStockAvailable")
    public ResultVO<Integer> getSumStockAvailable() {
        int sumStockAvailable = slMapper.sumStockAvailable();
        return ResultVO.success(sumStockAvailable);
    }

    @GetMapping("/getSumSlstoragerate")
    public ResultVO<String> getSumSlstoragerate() {
        Double sumSlstoragerate = slMapper.sumSlstoragerate();
        DecimalFormat df = new DecimalFormat("#.00");
//        System.out.println(df.format(sumSlstoragerate).toString());
        return ResultVO.success(df.format(sumSlstoragerate).toString());
    }

    @GetMapping("/getSlpicking")
    public ResultVO<Integer> getSlpicking() {
        int countSlpicking = slMapper.countSlpicking();
        return ResultVO.success(countSlpicking);
    }

    @GetMapping("/getlikeStorageloaction/{slnum}")
    public ResultVO<List<Storageloaction>> getlikeStorageloaction(@PathVariable String slnum) {
        System.out.println(slnum);
        List<Storageloaction> storageloactionList = slMapper.selectlikeStorageloaction(slnum);
        return ResultVO.success(storageloactionList);
    }
}
