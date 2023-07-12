package org.irecapi.controller;

import org.irecapi.entity.Issuance;
import org.irecapi.service.IssuanceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 签发记录表(Issuance)表控制层
 *
 * @author makejava
 * @since 2023-05-24 17:36:45
 */
@RestController
@RequestMapping("issuance")
public class IssuanceController {
    /**
     * 服务对象
     */
    @Resource
    private IssuanceService issuanceService;

    /**
     * 分页查询
     *
     * @param issuance 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Issuance>> queryByPage(Issuance issuance, PageRequest pageRequest) {
        return ResponseEntity.ok(this.issuanceService.queryByPage(issuance, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Issuance> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.issuanceService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param issuance 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Issuance> add(Issuance issuance) {
        return ResponseEntity.ok(this.issuanceService.insert(issuance));
    }

    /**
     * 编辑数据
     *
     * @param issuance 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Issuance> edit(Issuance issuance) {
        return ResponseEntity.ok(this.issuanceService.update(issuance));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.issuanceService.deleteById(id));
    }

}

