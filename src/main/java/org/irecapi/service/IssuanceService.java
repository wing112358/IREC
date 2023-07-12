package org.irecapi.service;

import org.irecapi.entity.Issuance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 签发记录表(Issuance)表服务接口
 *
 * @author makejava
 * @since 2023-05-24 17:36:45
 */
public interface IssuanceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Issuance queryById(Long id);

    /**
     * 通过ID查询单条数据
     *
     * @param packageId 主键
     * @return 实例对象
     */
    Issuance queryByPackageId(Integer packageId,String startTime);

    /**
     * 分页查询
     *
     * @param issuance 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Issuance> queryByPage(Issuance issuance, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param issuance 实例对象
     * @return 实例对象
     */
    Issuance insert(Issuance issuance);

    /**
     * 修改数据
     *
     * @param issuance 实例对象
     * @return 实例对象
     */
    Issuance update(Issuance issuance);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
