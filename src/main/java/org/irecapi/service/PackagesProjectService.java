package org.irecapi.service;

import org.irecapi.entity.PackagesProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 项目包与项目关联表(PackagesProject)表服务接口
 *
 * @author makejava
 * @since 2022-07-20 15:02:56
 */
public interface PackagesProjectService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PackagesProject queryById(Long id);

    /**
     * 分页查询
     *
     * @param packagesProject 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<PackagesProject> queryByPage(PackagesProject packagesProject, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param packagesProject 实例对象
     * @return 实例对象
     */
    PackagesProject insert(PackagesProject packagesProject);

    /**
     * 修改数据
     *
     * @param packagesProject 实例对象
     * @return 实例对象
     */
    PackagesProject update(PackagesProject packagesProject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
