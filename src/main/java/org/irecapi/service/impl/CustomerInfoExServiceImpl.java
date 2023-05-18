package org.irecapi.service.impl;

import org.irecapi.entity.CustomerInfoEx;
import org.irecapi.dao.CustomerInfoExDao;
import org.irecapi.service.CustomerInfoExService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 组织扩展信息表(CustomerInfoEx)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 15:02:30
 */
@Service("customerInfoExService")
public class CustomerInfoExServiceImpl implements CustomerInfoExService {
    @Resource
    private CustomerInfoExDao customerInfoExDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CustomerInfoEx queryById(Long id) {
        return this.customerInfoExDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param customerInfoEx 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CustomerInfoEx> queryByPage(CustomerInfoEx customerInfoEx, PageRequest pageRequest) {
        long total = this.customerInfoExDao.count(customerInfoEx);
        return new PageImpl<>(this.customerInfoExDao.queryAllByLimit(customerInfoEx, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param customerInfoEx 实例对象
     * @return 实例对象
     */
    @Override
    public CustomerInfoEx insert(CustomerInfoEx customerInfoEx) {
        this.customerInfoExDao.insert(customerInfoEx);
        return customerInfoEx;
    }

    /**
     * 修改数据
     *
     * @param customerInfoEx 实例对象
     * @return 实例对象
     */
    @Override
    public CustomerInfoEx update(CustomerInfoEx customerInfoEx) {
        this.customerInfoExDao.update(customerInfoEx);
        return this.queryById(customerInfoEx.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.customerInfoExDao.deleteById(id) > 0;
    }
}
