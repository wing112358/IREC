package org.irecapi.service;

import org.irecapi.entity.RegistrationDocuments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 注册成果文件表(RegistrationDocuments)表服务接口
 *
 * @author makejava
 * @since 2022-07-20 15:04:05
 */
public interface RegistrationDocumentsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RegistrationDocuments queryById(Long id);

    /**
     * 分页查询
     *
     * @param registrationDocuments 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RegistrationDocuments> queryByPage(RegistrationDocuments registrationDocuments, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param registrationDocuments 实例对象
     * @return 实例对象
     */
    RegistrationDocuments insert(RegistrationDocuments registrationDocuments);

    /**
     * 修改数据
     *
     * @param registrationDocuments 实例对象
     * @return 实例对象
     */
    RegistrationDocuments update(RegistrationDocuments registrationDocuments);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
