package org.irecapi.service.impl;

import org.irecapi.entity.Issuance;
import org.irecapi.dao.IssuanceDao;
import org.irecapi.service.IssuanceService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 签发记录表(Issuance)表服务实现类
 *
 * @author makejava
 * @since 2023-05-24 17:36:45
 */
@Service("issuanceService")
public class IssuanceServiceImpl implements IssuanceService {
    @Resource
    private IssuanceDao issuanceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Issuance queryById(Long id) {
        return this.issuanceDao.queryById(id);
    }

    @Override
    public Issuance queryByPackageId(Integer packageId,String startTime) {
        return this.issuanceDao.queryByPackageId(packageId,startTime);
    }

    /**
     * 分页查询
     *
     * @param issuance 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Issuance> queryByPage(Issuance issuance, PageRequest pageRequest) {
        long total = this.issuanceDao.count(issuance);
        return new PageImpl<>(this.issuanceDao.queryAllByLimit(issuance, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param issuance 实例对象
     * @return 实例对象
     */
    @Override
    public Issuance insert(Issuance issuance) {
        this.issuanceDao.insert(issuance);
        return issuance;
    }

    /**
     * 修改数据
     *
     * @param issuance 实例对象
     * @return 实例对象
     */
    @Override
    public Issuance update(Issuance issuance) {
        this.issuanceDao.update(issuance);
        return this.queryById(issuance.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.issuanceDao.deleteById(id) > 0;
    }
}
