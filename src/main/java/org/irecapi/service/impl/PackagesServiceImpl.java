package org.irecapi.service.impl;

import org.irecapi.entity.Packages;
import org.irecapi.dao.PackagesDao;
import org.irecapi.service.PackagesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 打包表(Packages)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 15:02:44
 */
@Service("packagesService")
public class PackagesServiceImpl implements PackagesService {
    @Resource
    private PackagesDao packagesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Packages queryById(Long id) {
        return this.packagesDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param packages 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Packages> queryByPage(Packages packages, PageRequest pageRequest) {
        long total = this.packagesDao.count(packages);
        return new PageImpl<>(this.packagesDao.queryAllByLimit(packages, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param packages 实例对象
     * @return 实例对象
     */
    @Override
    public Packages insert(Packages packages) {
        this.packagesDao.insert(packages);
        return packages;
    }

    /**
     * 修改数据
     *
     * @param packages 实例对象
     * @return 实例对象
     */
    @Override
    public Packages update(Packages packages) {
        this.packagesDao.update(packages);
        return this.queryById(packages.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.packagesDao.deleteById(id) > 0;
    }
}
