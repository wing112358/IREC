package org.irecapi.service;

import org.irecapi.entity.ProjectRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 项目注册资料表(ProjectRegistrationData)表服务接口
 *
 * @author makejava
 * @since 2022-07-20 15:03:50
 */
public interface ProjectRegistrationDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectRegistrationData queryById(Long id);

    ProjectRegistrationData queryByProjectId(Long projectId);

    /**
     * 分页查询
     *
     * @param projectRegistrationData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ProjectRegistrationData> queryByPage(ProjectRegistrationData projectRegistrationData, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param projectRegistrationData 实例对象
     * @return 实例对象
     */
    ProjectRegistrationData insert(ProjectRegistrationData projectRegistrationData);

    /**
     * 修改数据
     *
     * @param projectRegistrationData 实例对象
     * @return 实例对象
     */
    ProjectRegistrationData update(ProjectRegistrationData projectRegistrationData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
