package org.irecapi.service.impl;

import org.irecapi.entity.RegistrationResult;
import org.irecapi.dao.RegistrationResultDao;
import org.irecapi.service.RegistrationResultService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 注册结果表(RegistrationResult)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 15:04:29
 */
@Service("registrationResultService")
public class RegistrationResultServiceImpl implements RegistrationResultService {
    @Resource
    private RegistrationResultDao registrationResultDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RegistrationResult queryById(Long id) {
        return this.registrationResultDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param registrationResult 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RegistrationResult> queryByPage(RegistrationResult registrationResult, PageRequest pageRequest) {
        long total = this.registrationResultDao.count(registrationResult);
        return new PageImpl<>(this.registrationResultDao.queryAllByLimit(registrationResult, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param registrationResult 实例对象
     * @return 实例对象
     */
    @Override
    public RegistrationResult insert(RegistrationResult registrationResult) {
        this.registrationResultDao.insert(registrationResult);
        return registrationResult;
    }

    /**
     * 修改数据
     *
     * @param registrationResult 实例对象
     * @return 实例对象
     */
    @Override
    public RegistrationResult update(RegistrationResult registrationResult) {
        this.registrationResultDao.update(registrationResult);
        return this.queryById(registrationResult.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.registrationResultDao.deleteById(id) > 0;
    }
}
