package org.irecapi.controller;

import org.irecapi.entity.RegistrationResult;
import org.irecapi.service.RegistrationResultService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 注册结果表(RegistrationResult)表控制层
 *
 * @author makejava
 * @since 2022-07-20 15:04:29
 */
@RestController
@RequestMapping("registrationResult")
public class RegistrationResultController {
    /**
     * 服务对象
     */
    @Resource
    private RegistrationResultService registrationResultService;

    /**
     * 分页查询
     *
     * @param registrationResult 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<RegistrationResult>> queryByPage(RegistrationResult registrationResult, PageRequest pageRequest) {
        return ResponseEntity.ok(this.registrationResultService.queryByPage(registrationResult, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RegistrationResult> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.registrationResultService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param registrationResult 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RegistrationResult> add(RegistrationResult registrationResult) {
        return ResponseEntity.ok(this.registrationResultService.insert(registrationResult));
    }

    /**
     * 编辑数据
     *
     * @param registrationResult 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RegistrationResult> edit(RegistrationResult registrationResult) {
        return ResponseEntity.ok(this.registrationResultService.update(registrationResult));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.registrationResultService.deleteById(id));
    }

}

