package com.website.company.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.Maison;
import com.website.company.mapper.MaisonMapper;
import com.website.company.service.MaisonService;
import com.website.company.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pengyangyan
 */
@RestController
@RequestMapping("api/maison")
public class MaisonController {

    @Resource
    private MaisonMapper maisonMapper;

    @GetMapping("/getList")
    List<Maison> getList(){
        return maisonMapper.selectList(new EntityWrapper<>());
    }

    @GetMapping("/get")
    ResponseBo get(@RequestParam("id") Integer id){
        try{
            Maison maison = maisonMapper.selectById(id);
            return ResponseBo.ok(maison);
        }catch (Exception e){
            return ResponseBo.error(e.getMessage());
        }
    }

    @GetMapping("/delete")
    ResponseBo delete(@RequestParam Integer id){
        try{
            maisonMapper.deleteById(id);
            return ResponseBo.ok();
        }catch (Exception e){
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseBo save(@RequestBody Maison maison){
        if (maison.getId()==null){
            try{
                maisonMapper.insert(maison);
                return ResponseBo.ok("添加成功");
            }catch (Exception e){
                return ResponseBo.error(e.getMessage());
            }
        }else {
            try{
                maisonMapper.updateById(maison);
                return ResponseBo.ok("更新成功");
            }catch (Exception e){
                return ResponseBo.error(e.getMessage());
            }
        }
    }


}
