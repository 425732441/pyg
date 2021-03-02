package com.zhl.pygmanagerweb.controller;

import com.zhl.pyg.pojo.TbBrand;
import com.zhl.pygsellergoodsinterface.BrandService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zhanghualei
 * @Classname NewController
 * @Date 2021/3/1 23:22
 */
@RestController
@RequestMapping("/management")
public class NewController {
    @DubboReference
    BrandService brandService;

    @RequestMapping("/getBrandAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

}
