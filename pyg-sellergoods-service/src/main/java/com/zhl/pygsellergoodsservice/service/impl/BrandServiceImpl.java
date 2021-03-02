package com.zhl.pygsellergoodsservice.service.impl;

import com.zhl.pyg.mapper.TbBrandMapper;
import com.zhl.pyg.pojo.TbBrand;
import com.zhl.pygsellergoodsinterface.BrandService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Zhanghualei
 * @Classname BrandServiceImpl
 * @Date 2021/3/1 23:44
 */
@DubboService
public class BrandServiceImpl implements BrandService {

    @Autowired
    TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }
}
