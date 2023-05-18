package org.irecapi.service.impl;

import org.irecapi.entity.RegistrationDocumentsExportLog;
import org.irecapi.dao.RegistrationDocumentsExportLogDao;
import org.irecapi.service.RegistrationDocumentsExportLogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 注册成果文件导出记录表(RegistrationDocumentsExportLog)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 15:04:19
 */
@Service("registrationDocumentsExportLogService")
public class RegistrationDocumentsExportLogServiceImpl implements RegistrationDocumentsExportLogService {
    @Resource
    private RegistrationDocumentsExportLogDao registrationDocumentsExportLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RegistrationDocumentsExportLog queryById(Long id) {
        return this.registrationDocumentsExportLogDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param registrationDocumentsExportLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RegistrationDocumentsExportLog> queryByPage(RegistrationDocumentsExportLog registrationDocumentsExportLog, PageRequest pageRequest) {
        long total = this.registrationDocumentsExportLogDao.count(registrationDocumentsExportLog);
        return new PageImpl<>(this.registrationDocumentsExportLogDao.queryAllByLimit(registrationDocumentsExportLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param registrationDocumentsExportLog 实例对象
     * @return 实例对象
     */
    @Override
    public RegistrationDocumentsExportLog insert(RegistrationDocumentsExportLog registrationDocumentsExportLog) {
        this.registrationDocumentsExportLogDao.insert(registrationDocumentsExportLog);
        return registrationDocumentsExportLog;
    }

    /**
     * 修改数据
     *
     * @param registrationDocumentsExportLog 实例对象
     * @return 实例对象
     */
    @Override
    public RegistrationDocumentsExportLog update(RegistrationDocumentsExportLog registrationDocumentsExportLog) {
        this.registrationDocumentsExportLogDao.update(registrationDocumentsExportLog);
        return this.queryById(registrationDocumentsExportLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.registrationDocumentsExportLogDao.deleteById(id) > 0;
    }
}
