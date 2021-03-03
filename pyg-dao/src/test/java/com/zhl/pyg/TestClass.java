package com.zhl.pyg;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zhl.pyg.dao.TbBrandDao;
import com.zhl.pyg.entity.TbBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Zhanghualei
 * @Classname TestClass
 * @Date 2021/3/3 9:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("db")
public class TestClass {
    @Autowired
    private TbBrandDao brandDao;

    @Test
    public void testPage() {
        List<TbBrand> tbBrands = brandDao.selectList((Wrapper<TbBrand>)null);
        System.out.println(tbBrands);
    }


}
