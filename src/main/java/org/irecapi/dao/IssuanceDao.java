package org.irecapi.dao;

import org.irecapi.entity.Issuance;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 签发记录表(Issuance)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-24 17:36:45
 */
public interface IssuanceDao {

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
     * 查询指定行数据
     *
     * @param issuance 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Issuance> queryAllByLimit(Issuance issuance, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param issuance 查询条件
     * @return 总行数
     */
    long count(Issuance issuance);

    /**
     * 新增数据
     *
     * @param issuance 实例对象
     * @return 影响行数
     */
    int insert(Issuance issuance);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Issuance> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Issuance> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Issuance> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Issuance> entities);

    /**
     * 修改数据
     *
     * @param issuance 实例对象
     * @return 影响行数
     */
    int update(Issuance issuance);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

