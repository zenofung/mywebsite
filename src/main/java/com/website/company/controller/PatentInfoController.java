package com.website.company.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.PatentInfo;
import com.website.company.mapper.PatentInfoMapper;
import com.website.company.service.PatentInfoService;
import com.website.company.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/patent")
public class PatentInfoController {

    @Resource
    private PatentInfoMapper patentInfoMapper;
    @Autowired
    PatentInfoService patentInfoService;

    @GetMapping("/get")
    ResponseBo getPatentInfo(@RequestParam("id") Integer id){
        try{
            PatentInfo PatentInfo = patentInfoMapper.selectById(id);
            return ResponseBo.ok(PatentInfo);
        }catch (Exception e){
            return ResponseBo.error(e.getMessage());
        }
    }


    @GetMapping("/getList")
    List<PatentInfo> getList() {
        return patentInfoService.patentInfoList();
    }

    @GetMapping("/delete")
    ResponseBo delete(@RequestParam("id") Integer id) {
        try {
            patentInfoMapper.deleteById(id);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseBo savePatent(@RequestBody PatentInfo PatentInfo) {
        if (PatentInfo.getId() == null) {
            try {
                patentInfoMapper.insert(PatentInfo);
                return ResponseBo.ok();
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                patentInfoMapper.updateById(PatentInfo);
                return ResponseBo.ok();
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }
}
