package org.irecapi.service.impl;

import org.irecapi.entity.ProjectRegistrationData;
import org.irecapi.dao.ProjectRegistrationDataDao;
import org.irecapi.service.ProjectRegistrationDataService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 项目注册资料表(ProjectRegistrationData)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 15:03:50
 */
@Service("projectRegistrationDataService")
public class ProjectRegistrationDataServiceImpl implements ProjectRegistrationDataService {
    @Resource
    private ProjectRegistrationDataDao projectRegistrationDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectRegistrationData queryById(Long id) {
        return this.projectRegistrationDataDao.queryById(id);
    }

    /**
     * 通过项目ID查询单条数据
     *
     * @param projectId 主键
     * @return 实例对象
     */
    @Override
    public ProjectRegistrationData queryByProjectId(Long projectId) {
        return this.projectRegistrationDataDao.queryByProjectId(projectId);
    }

    /**
     * 分页查询
     *
     * @param projectRegistrationData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ProjectRegistrationData> queryByPage(ProjectRegistrationData projectRegistrationData, PageRequest pageRequest) {
        long total = this.projectRegistrationDataDao.count(projectRegistrationData);
        return new PageImpl<>(this.projectRegistrationDataDao.queryAllByLimit(projectRegistrationData, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param projectRegistrationData 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectRegistrationData insert(ProjectRegistrationData projectRegistrationData) {
        this.projectRegistrationDataDao.insert(projectRegistrationData);
        return projectRegistrationData;
    }

    /**
     * 修改数据
     *
     * @param projectRegistrationData 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectRegistrationData update(ProjectRegistrationData projectRegistrationData) {
        this.projectRegistrationDataDao.update(projectRegistrationData);
        return this.queryById(projectRegistrationData.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.projectRegistrationDataDao.deleteById(id) > 0;
    }
}
