package org.irecapi.service;

import org.irecapi.entity.ContentEn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 内容en表(ContentEn)表服务接口
 *
 * @author makejava
 * @since 2022-07-20 15:02:09
 */
public interface ContentEnService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ContentEn queryById(Long id);

    /**
     * 分页查询
     *
     * @param contentEn 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ContentEn> queryByPage(ContentEn contentEn, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param contentEn 实例对象
     * @return 实例对象
     */
    ContentEn insert(ContentEn contentEn);

    /**
     * 修改数据
     *
     * @param contentEn 实例对象
     * @return 实例对象
     */
    ContentEn update(ContentEn contentEn);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
