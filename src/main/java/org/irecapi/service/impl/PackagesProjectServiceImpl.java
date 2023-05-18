package org.irecapi.service.impl;

import org.irecapi.entity.PackagesProject;
import org.irecapi.dao.PackagesProjectDao;
import org.irecapi.service.PackagesProjectService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 项目包与项目关联表(PackagesProject)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 15:02:56
 */
@Service("packagesProjectService")
public class PackagesProjectServiceImpl implements PackagesProjectService {
    @Resource
    private PackagesProjectDao packagesProjectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PackagesProject queryById(Long id) {
        return this.packagesProjectDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param packagesProject 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<PackagesProject> queryByPage(PackagesProject packagesProject, PageRequest pageRequest) {
        long total = this.packagesProjectDao.count(packagesProject);
        return new PageImpl<>(this.packagesProjectDao.queryAllByLimit(packagesProject, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param packagesProject 实例对象
     * @return 实例对象
     */
    @Override
    public PackagesProject insert(PackagesProject packagesProject) {
        this.packagesProjectDao.insert(packagesProject);
        return packagesProject;
    }

    /**
     * 修改数据
     *
     * @param packagesProject 实例对象
     * @return 实例对象
     */
    @Override
    public PackagesProject update(PackagesProject packagesProject) {
        this.packagesProjectDao.update(packagesProject);
        return this.queryById(packagesProject.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.packagesProjectDao.deleteById(id) > 0;
    }
}
