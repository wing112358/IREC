package org.irecapi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.irecapi.entity.RegistrationResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 注册结果表(RegistrationResult)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 15:04:29
 */
@Mapper
public interface RegistrationResultDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RegistrationResult queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param registrationResult 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RegistrationResult> queryAllByLimit(RegistrationResult registrationResult, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param registrationResult 查询条件
     * @return 总行数
     */
    long count(RegistrationResult registrationResult);

    /**
     * 新增数据
     *
     * @param registrationResult 实例对象
     * @return 影响行数
     */
    int insert(RegistrationResult registrationResult);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RegistrationResult> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RegistrationResult> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RegistrationResult> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RegistrationResult> entities);

    /**
     * 修改数据
     *
     * @param registrationResult 实例对象
     * @return 影响行数
     */
    int update(RegistrationResult registrationResult);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

