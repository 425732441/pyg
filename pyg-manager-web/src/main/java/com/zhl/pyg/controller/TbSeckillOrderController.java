package com.zhl.pyg.controller;

import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhl.pyg.response.PageResult;
import com.zhl.pyg.response.Result;
import com.zhl.pyg.response.StatusCode;
import com.zhl.pyg.entity.TbSeckillOrder;
import com.zhl.pyg.service.TbSeckillOrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;

import java.util.List;
import java.util.Objects;

/**
 * (TbSeckillOrder)控制层
 *
 * @author protagonist
 * @since 2021-03-03 16:41:28
 */
@RestController
@Slf4j
@RequestMapping("/tbSeckillOrder")
public class TbSeckillOrderController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbSeckillOrderService tbSeckillOrderServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(value = "/get/{id}")
    public Result selectOne(@PathVariable("id") Long id) {
        TbSeckillOrder result = tbSeckillOrderServiceImpl.selectById(id);
        if (Objects.nonNull(result)) {
            return new Result<>(true, StatusCode.OK, "查询成功", result);
        }
        return new Result<>(true, StatusCode.ERROR, "查询失败");
    }

    /**
     * 新增一条数据
     *
     * @param tbSeckillOrder 实体类
     * @return Result对象
     */
    @PostMapping(value = "/insert")
    public Result insert(@RequestBody TbSeckillOrder tbSeckillOrder) {
        int result = tbSeckillOrderServiceImpl.insert(tbSeckillOrder);
        if (result > 0) {
            return new Result<>(true, StatusCode.OK, "新增成功", result);
        }
        return new Result<>(true, StatusCode.ERROR, "新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param tbSeckillOrder 实体类
     * @return Result对象
     */
    @PutMapping(value = "/update")
    public Result update(@RequestBody TbSeckillOrder tbSeckillOrder) {
        TbSeckillOrder result = tbSeckillOrderServiceImpl.update(tbSeckillOrder);
        if (Objects.nonNull(result)) {
            return new Result<>(true, StatusCode.OK, "修改成功", result);
        }
        return new Result<>(true, StatusCode.ERROR, "修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param id 主键
     * @return Result对象
     */
    @DeleteMapping(value = "/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        int result = tbSeckillOrderServiceImpl.deleteById(id);
        if (result > 0) {
            return new Result<>(true, StatusCode.OK, "删除成功", result);
        }
        return new Result<>(true, StatusCode.ERROR, "删除失败");
    }

    /**
     * 查询全部
     *
     * @return Result对象
     */
    @GetMapping(value = "/selectAll")
    public Result<List<TbSeckillOrder>> selectAll() {
        List<TbSeckillOrder> tbSeckillOrders = tbSeckillOrderServiceImpl.selectAll();
        if (CollectionUtils.isEmpty(tbSeckillOrders)) {
            return new Result<>(true, StatusCode.ERROR, "查询全部数据失败");
        }
        return new Result<>(true, StatusCode.OK, "查询全部数据成功", tbSeckillOrders);

    }

    /**
     * 分页查询
     *
     * @param current 当前页  第零页和第一页的数据是一样
     * @param size    每一页的数据条数
     * @return Result对象
     */
    @GetMapping(value = "/selectPage/{current}/{size}")
    public Result selectPage(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        IPage<TbSeckillOrder> page = tbSeckillOrderServiceImpl.selectPage(current, size);
        if (Objects.nonNull(page)) {
            return new Result<>(true, StatusCode.OK, "分页条件查询成功", new PageResult<>(page.getTotal(), page.getRecords()));
        }
        return new Result<>(true, StatusCode.ERROR, "分页查询数据失败");
    }

}
