package org.irecapi.controller;

import org.irecapi.entity.CustomerInfoEx;
import org.irecapi.service.CustomerInfoExService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 组织扩展信息表(CustomerInfoEx)表控制层
 *
 * @author makejava
 * @since 2022-07-20 15:02:30
 */
@RestController
@RequestMapping("customerInfoEx")
public class CustomerInfoExController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerInfoExService customerInfoExService;

    /**
     * 分页查询
     *
     * @param customerInfoEx 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CustomerInfoEx>> queryByPage(CustomerInfoEx customerInfoEx, PageRequest pageRequest) {
        return ResponseEntity.ok(this.customerInfoExService.queryByPage(customerInfoEx, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CustomerInfoEx> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.customerInfoExService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param customerInfoEx 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CustomerInfoEx> add(CustomerInfoEx customerInfoEx) {
        return ResponseEntity.ok(this.customerInfoExService.insert(customerInfoEx));
    }

    /**
     * 编辑数据
     *
     * @param customerInfoEx 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CustomerInfoEx> edit(CustomerInfoEx customerInfoEx) {
        return ResponseEntity.ok(this.customerInfoExService.update(customerInfoEx));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.customerInfoExService.deleteById(id));
    }

}

