package org.irecapi.controller;

import org.irecapi.entity.RegistrationDocuments;
import org.irecapi.service.RegistrationDocumentsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 注册成果文件表(RegistrationDocuments)表控制层
 *
 * @author makejava
 * @since 2022-07-20 15:04:05
 */
@RestController
@RequestMapping("registrationDocuments")
public class RegistrationDocumentsController {
    /**
     * 服务对象
     */
    @Resource
    private RegistrationDocumentsService registrationDocumentsService;

    /**
     * 分页查询
     *
     * @param registrationDocuments 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<RegistrationDocuments>> queryByPage(RegistrationDocuments registrationDocuments, PageRequest pageRequest) {
        return ResponseEntity.ok(this.registrationDocumentsService.queryByPage(registrationDocuments, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RegistrationDocuments> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.registrationDocumentsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param registrationDocuments 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RegistrationDocuments> add(RegistrationDocuments registrationDocuments) {
        return ResponseEntity.ok(this.registrationDocumentsService.insert(registrationDocuments));
    }

    /**
     * 编辑数据
     *
     * @param registrationDocuments 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RegistrationDocuments> edit(RegistrationDocuments registrationDocuments) {
        return ResponseEntity.ok(this.registrationDocumentsService.update(registrationDocuments));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.registrationDocumentsService.deleteById(id));
    }

}

