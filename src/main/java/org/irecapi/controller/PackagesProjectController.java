package org.irecapi.controller;

import org.irecapi.entity.PackagesProject;
import org.irecapi.service.PackagesProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目包与项目关联表(PackagesProject)表控制层
 *
 * @author makejava
 * @since 2022-07-20 15:02:56
 */
@RestController
@RequestMapping("packagesProject")
public class PackagesProjectController {
    /**
     * 服务对象
     */
    @Resource
    private PackagesProjectService packagesProjectService;

    /**
     * 分页查询
     *
     * @param packagesProject 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<PackagesProject>> queryByPage(PackagesProject packagesProject, PageRequest pageRequest) {
        return ResponseEntity.ok(this.packagesProjectService.queryByPage(packagesProject, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<PackagesProject> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.packagesProjectService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param packagesProject 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<PackagesProject> add(PackagesProject packagesProject) {
        return ResponseEntity.ok(this.packagesProjectService.insert(packagesProject));
    }

    /**
     * 编辑数据
     *
     * @param packagesProject 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<PackagesProject> edit(PackagesProject packagesProject) {
        return ResponseEntity.ok(this.packagesProjectService.update(packagesProject));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.packagesProjectService.deleteById(id));
    }

}

