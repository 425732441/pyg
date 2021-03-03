package com.zhl.pyg.controller;

import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhl.pyg.response.PageResult;
import com.zhl.pyg.response.Result;
import com.zhl.pyg.response.StatusCode;
import com.zhl.pyg.entity.TbPayLog;
import com.zhl.pyg.service.TbPayLogService;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;

import java.util.List;
import java.util.Objects;

/**
 * (TbPayLog)控制层
 *
 * @author protagonist
 * @since 2021-03-03 16:41:27
 */
@RestController
@Slf4j
@RequestMapping("/tbPayLog")
public class TbPayLogController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbPayLogService tbPayLogServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param outTradeNo 主键
     * @return 单条数据
     */
    @GetMapping(value = "/get/{outTradeNo}")
    public Result selectOne(@PathVariable("outTradeNo") String outTradeNo) {
        TbPayLog result = tbPayLogServiceImpl.selectById(outTradeNo);
        if (Objects.nonNull(result)) {
            return new Result<>(true, StatusCode.OK, "查询成功", result);
        }
        return new Result<>(true, StatusCode.ERROR, "查询失败");
    }

    /**
     * 新增一条数据
     *
     * @param tbPayLog 实体类
     * @return Result对象
     */
    @PostMapping(value = "/insert")
    public Result insert(@RequestBody TbPayLog tbPayLog) {
        int result = tbPayLogServiceImpl.insert(tbPayLog);
        if (result > 0) {
            return new Result<>(true, StatusCode.OK, "新增成功", result);
        }
        return new Result<>(true, StatusCode.ERROR, "新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param tbPayLog 实体类
     * @return Result对象
     */
    @PutMapping(value = "/update")
    public Result update(@RequestBody TbPayLog tbPayLog) {
        TbPayLog result = tbPayLogServiceImpl.update(tbPayLog);
        if (Objects.nonNull(result)) {
            return new Result<>(true, StatusCode.OK, "修改成功", result);
        }
        return new Result<>(true, StatusCode.ERROR, "修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param outTradeNo 主键
     * @return Result对象
     */
    @DeleteMapping(value = "/delete/{outTradeNo}")
    public Result delete(@PathVariable("outTradeNo") String outTradeNo) {
        int result = tbPayLogServiceImpl.deleteById(outTradeNo);
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
    public Result<List<TbPayLog>> selectAll() {
        List<TbPayLog> tbPayLogs = tbPayLogServiceImpl.selectAll();
        if (CollectionUtils.isEmpty(tbPayLogs)) {
            return new Result<>(true, StatusCode.ERROR, "查询全部数据失败");
        }
        return new Result<>(true, StatusCode.OK, "查询全部数据成功", tbPayLogs);

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
        IPage<TbPayLog> page = tbPayLogServiceImpl.selectPage(current, size);
        if (Objects.nonNull(page)) {
            return new Result<>(true, StatusCode.OK, "分页条件查询成功", new PageResult<>(page.getTotal(), page.getRecords()));
        }
        return new Result<>(true, StatusCode.ERROR, "分页查询数据失败");
    }

}
