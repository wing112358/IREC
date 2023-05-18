package org.irecapi.service.impl;

import org.irecapi.entity.RegistrationDocuments;
import org.irecapi.dao.RegistrationDocumentsDao;
import org.irecapi.service.RegistrationDocumentsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 注册成果文件表(RegistrationDocuments)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 15:04:05
 */
@Service("registrationDocumentsService")
public class RegistrationDocumentsServiceImpl implements RegistrationDocumentsService {
    @Resource
    private RegistrationDocumentsDao registrationDocumentsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RegistrationDocuments queryById(Long id) {
        return this.registrationDocumentsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param registrationDocuments 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RegistrationDocuments> queryByPage(RegistrationDocuments registrationDocuments, PageRequest pageRequest) {
        long total = this.registrationDocumentsDao.count(registrationDocuments);
        return new PageImpl<>(this.registrationDocumentsDao.queryAllByLimit(registrationDocuments, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param registrationDocuments 实例对象
     * @return 实例对象
     */
    @Override
    public RegistrationDocuments insert(RegistrationDocuments registrationDocuments) {
        this.registrationDocumentsDao.insert(registrationDocuments);
        return registrationDocuments;
    }

    /**
     * 修改数据
     *
     * @param registrationDocuments 实例对象
     * @return 实例对象
     */
    @Override
    public RegistrationDocuments update(RegistrationDocuments registrationDocuments) {
        this.registrationDocumentsDao.update(registrationDocuments);
        return this.queryById(registrationDocuments.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.registrationDocumentsDao.deleteById(id) > 0;
    }
}
