package org.irecapi.controller;

import org.irecapi.entity.Packages;
import org.irecapi.service.PackagesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 打包表(Packages)表控制层
 *
 * @author makejava
 * @since 2022-07-20 15:02:44
 */
@RestController
@RequestMapping("packages")
public class PackagesController {
    /**
     * 服务对象
     */
    @Resource
    private PackagesService packagesService;

    /**
     * 分页查询
     *
     * @param packages 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Packages>> queryByPage(Packages packages, PageRequest pageRequest) {
        return ResponseEntity.ok(this.packagesService.queryByPage(packages, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Packages> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.packagesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param packages 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Packages> add(Packages packages) {
        return ResponseEntity.ok(this.packagesService.insert(packages));
    }

    /**
     * 编辑数据
     *
     * @param packages 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Packages> edit(Packages packages) {
        return ResponseEntity.ok(this.packagesService.update(packages));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.packagesService.deleteById(id));
    }

}

