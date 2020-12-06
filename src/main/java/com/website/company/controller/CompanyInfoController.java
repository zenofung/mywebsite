package com.website.company.controller;


import com.website.company.entity.CompanyInfo;
import com.website.company.service.CompanyInfoService;
import com.website.company.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/api/companyInfo")
public class CompanyInfoController {
    @Autowired
    CompanyInfoService companyInfoService;

    @GetMapping("/getCompany")
    public ResponseBo getCompanyInfo() {
        try {
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            return ResponseBo.ok(companyDetail);
        } catch (Exception e) {
            return ResponseBo.error();
        }
    }

    @PostMapping("/saveCompany")
    public ResponseBo saveCompanyInfo(@RequestBody CompanyInfo companyInfo) {
        if (companyInfo.getId() == null) {
            try {
                companyInfoService.addCompany(companyInfo);
                return ResponseBo.ok("新增成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                companyInfoService.editCompany(companyInfo);
                return ResponseBo.ok("修改成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }

}
