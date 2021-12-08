package com.example.mall.controller;


import com.example.mall.common.api.CommonPage;
import com.example.mall.common.api.CommonResult;
import com.example.mall.mbg.model.PmsBrand;
import com.example.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 品牌管理Controller
 */
@Controller
@Api(tags = "品牌")
@RequestMapping("/brand")
@Slf4j
public class PmsBrandController {
    @Autowired
    private PmsBrandService demoService;



    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询品牌列表")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(demoService.listAllBrand());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "创建品牌列表")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = demoService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            log.info("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.error("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新品牌")
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult commonResult;
        int count = demoService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            log.info("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.error("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "删除品牌")
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = demoService.deleteBrand(id);
        if (count == 1) {
            log.info("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.error("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询品牌")
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = demoService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "id查询品牌")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(demoService.getBrand(id));
    }
}

