package org.irecapi.service;

import org.irecapi.entity.Packages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 打包表(Packages)表服务接口
 *
 * @author makejava
 * @since 2022-07-20 15:02:44
 */
public interface PackagesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Packages queryById(Long id);

    /**
     * 分页查询
     *
     * @param packages 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Packages> queryByPage(Packages packages, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param packages 实例对象
     * @return 实例对象
     */
    Packages insert(Packages packages);

    /**
     * 修改数据
     *
     * @param packages 实例对象
     * @return 实例对象
     */
    Packages update(Packages packages);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
