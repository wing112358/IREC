package org.irecapi.controller;

import org.irecapi.entity.ContentEn;
import org.irecapi.service.ContentEnService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 内容en表(ContentEn)表控制层
 *
 * @author makejava
 * @since 2022-07-20 15:02:06
 */
@RestController
@RequestMapping("contentEn")
public class ContentEnController {
    /**
     * 服务对象
     */
    @Resource
    private ContentEnService contentEnService;

    /**
     * 分页查询
     *
     * @param contentEn 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ContentEn>> queryByPage(ContentEn contentEn, PageRequest pageRequest) {
        return ResponseEntity.ok(this.contentEnService.queryByPage(contentEn, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ContentEn> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.contentEnService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param contentEn 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ContentEn> add(ContentEn contentEn) {
        return ResponseEntity.ok(this.contentEnService.insert(contentEn));
    }

    /**
     * 编辑数据
     *
     * @param contentEn 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ContentEn> edit(ContentEn contentEn) {
        return ResponseEntity.ok(this.contentEnService.update(contentEn));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.contentEnService.deleteById(id));
    }

}

