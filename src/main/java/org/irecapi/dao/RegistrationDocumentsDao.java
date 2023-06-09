package org.irecapi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.irecapi.entity.RegistrationDocuments;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 注册成果文件表(RegistrationDocuments)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 15:04:05
 */
@Mapper
public interface RegistrationDocumentsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RegistrationDocuments queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param registrationDocuments 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RegistrationDocuments> queryAllByLimit(RegistrationDocuments registrationDocuments, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param registrationDocuments 查询条件
     * @return 总行数
     */
    long count(RegistrationDocuments registrationDocuments);

    /**
     * 新增数据
     *
     * @param registrationDocuments 实例对象
     * @return 影响行数
     */
    int insert(RegistrationDocuments registrationDocuments);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RegistrationDocuments> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RegistrationDocuments> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RegistrationDocuments> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RegistrationDocuments> entities);

    /**
     * 修改数据
     *
     * @param registrationDocuments 实例对象
     * @return 影响行数
     */
    int update(RegistrationDocuments registrationDocuments);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

