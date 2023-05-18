package org.irecapi.controller;

import org.irecapi.entity.RegistrationDocumentsExportLog;
import org.irecapi.service.RegistrationDocumentsExportLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 注册成果文件导出记录表(RegistrationDocumentsExportLog)表控制层
 *
 * @author makejava
 * @since 2022-07-20 15:04:19
 */
@RestController
@RequestMapping("registrationDocumentsExportLog")
public class RegistrationDocumentsExportLogController {
    /**
     * 服务对象
     */
    @Resource
    private RegistrationDocumentsExportLogService registrationDocumentsExportLogService;

    /**
     * 分页查询
     *
     * @param registrationDocumentsExportLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<RegistrationDocumentsExportLog>> queryByPage(RegistrationDocumentsExportLog registrationDocumentsExportLog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.registrationDocumentsExportLogService.queryByPage(registrationDocumentsExportLog, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RegistrationDocumentsExportLog> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.registrationDocumentsExportLogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param registrationDocumentsExportLog 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RegistrationDocumentsExportLog> add(RegistrationDocumentsExportLog registrationDocumentsExportLog) {
        return ResponseEntity.ok(this.registrationDocumentsExportLogService.insert(registrationDocumentsExportLog));
    }

    /**
     * 编辑数据
     *
     * @param registrationDocumentsExportLog 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RegistrationDocumentsExportLog> edit(RegistrationDocumentsExportLog registrationDocumentsExportLog) {
        return ResponseEntity.ok(this.registrationDocumentsExportLogService.update(registrationDocumentsExportLog));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.registrationDocumentsExportLogService.deleteById(id));
    }

}

