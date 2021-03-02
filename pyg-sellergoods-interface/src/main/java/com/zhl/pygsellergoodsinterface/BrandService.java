package com.zhl.pygsellergoodsinterface;

import com.zhl.pyg.pojo.TbBrand;

import java.util.List;

/**
 * @author Zhanghualei
 * @Classname BrandService
 * @Date 2021/3/1 23:24
 */
public interface BrandService {
    /**
     * 返回全部列表
     *
     * @return
     */
    List<TbBrand> findAll();

}
