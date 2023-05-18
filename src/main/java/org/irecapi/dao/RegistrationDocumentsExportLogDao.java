package org.irecapi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.irecapi.entity.RegistrationDocumentsExportLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 注册成果文件导出记录表(RegistrationDocumentsExportLog)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 15:04:19
 */
@Mapper
public interface RegistrationDocumentsExportLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RegistrationDocumentsExportLog queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param registrationDocumentsExportLog 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RegistrationDocumentsExportLog> queryAllByLimit(RegistrationDocumentsExportLog registrationDocumentsExportLog, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param registrationDocumentsExportLog 查询条件
     * @return 总行数
     */
    long count(RegistrationDocumentsExportLog registrationDocumentsExportLog);

    /**
     * 新增数据
     *
     * @param registrationDocumentsExportLog 实例对象
     * @return 影响行数
     */
    int insert(RegistrationDocumentsExportLog registrationDocumentsExportLog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RegistrationDocumentsExportLog> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RegistrationDocumentsExportLog> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RegistrationDocumentsExportLog> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RegistrationDocumentsExportLog> entities);

    /**
     * 修改数据
     *
     * @param registrationDocumentsExportLog 实例对象
     * @return 影响行数
     */
    int update(RegistrationDocumentsExportLog registrationDocumentsExportLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

