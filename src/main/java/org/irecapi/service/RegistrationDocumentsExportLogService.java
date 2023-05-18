package org.irecapi.service;

import org.irecapi.entity.RegistrationDocumentsExportLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 注册成果文件导出记录表(RegistrationDocumentsExportLog)表服务接口
 *
 * @author makejava
 * @since 2022-07-20 15:04:19
 */
public interface RegistrationDocumentsExportLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RegistrationDocumentsExportLog queryById(Long id);

    /**
     * 分页查询
     *
     * @param registrationDocumentsExportLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RegistrationDocumentsExportLog> queryByPage(RegistrationDocumentsExportLog registrationDocumentsExportLog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param registrationDocumentsExportLog 实例对象
     * @return 实例对象
     */
    RegistrationDocumentsExportLog insert(RegistrationDocumentsExportLog registrationDocumentsExportLog);

    /**
     * 修改数据
     *
     * @param registrationDocumentsExportLog 实例对象
     * @return 实例对象
     */
    RegistrationDocumentsExportLog update(RegistrationDocumentsExportLog registrationDocumentsExportLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
