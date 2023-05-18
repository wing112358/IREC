package org.irecapi.service;

import org.irecapi.entity.CustomerInfoEx;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 组织扩展信息表(CustomerInfoEx)表服务接口
 *
 * @author makejava
 * @since 2022-07-20 15:02:30
 */
public interface CustomerInfoExService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CustomerInfoEx queryById(Long id);

    /**
     * 分页查询
     *
     * @param customerInfoEx 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CustomerInfoEx> queryByPage(CustomerInfoEx customerInfoEx, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param customerInfoEx 实例对象
     * @return 实例对象
     */
    CustomerInfoEx insert(CustomerInfoEx customerInfoEx);

    /**
     * 修改数据
     *
     * @param customerInfoEx 实例对象
     * @return 实例对象
     */
    CustomerInfoEx update(CustomerInfoEx customerInfoEx);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
