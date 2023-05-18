package org.irecapi.controller;

import org.irecapi.entity.ProjectRegistrationData;
import org.irecapi.service.ProjectRegistrationDataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目注册资料表(ProjectRegistrationData)表控制层
 *
 * @author makejava
 * @since 2022-07-20 15:03:49
 */
@RestController
@RequestMapping("projectRegistrationData")
public class ProjectRegistrationDataController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectRegistrationDataService projectRegistrationDataService;

    /**
     * 分页查询
     *
     * @param projectRegistrationData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ProjectRegistrationData>> queryByPage(ProjectRegistrationData projectRegistrationData, PageRequest pageRequest) {
        return ResponseEntity.ok(this.projectRegistrationDataService.queryByPage(projectRegistrationData, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ProjectRegistrationData> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.projectRegistrationDataService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param projectRegistrationData 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ProjectRegistrationData> add(ProjectRegistrationData projectRegistrationData) {
        return ResponseEntity.ok(this.projectRegistrationDataService.insert(projectRegistrationData));
    }

    /**
     * 编辑数据
     *
     * @param projectRegistrationData 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ProjectRegistrationData> edit(ProjectRegistrationData projectRegistrationData) {
        return ResponseEntity.ok(this.projectRegistrationDataService.update(projectRegistrationData));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.projectRegistrationDataService.deleteById(id));
    }

}

