package org.irecapi.service;

import org.irecapi.entity.RegistrationResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 注册结果表(RegistrationResult)表服务接口
 *
 * @author makejava
 * @since 2022-07-20 15:04:29
 */
public interface RegistrationResultService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RegistrationResult queryById(Long id);

    /**
     * 分页查询
     *
     * @param registrationResult 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RegistrationResult> queryByPage(RegistrationResult registrationResult, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param registrationResult 实例对象
     * @return 实例对象
     */
    RegistrationResult insert(RegistrationResult registrationResult);

    /**
     * 修改数据
     *
     * @param registrationResult 实例对象
     * @return 实例对象
     */
    RegistrationResult update(RegistrationResult registrationResult);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
