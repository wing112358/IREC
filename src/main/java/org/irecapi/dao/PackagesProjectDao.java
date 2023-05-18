package org.irecapi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.irecapi.entity.PackagesProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 项目包与项目关联表(PackagesProject)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 15:02:56
 */
@Mapper
public interface PackagesProjectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PackagesProject queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param packagesProject 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PackagesProject> queryAllByLimit(PackagesProject packagesProject, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param packagesProject 查询条件
     * @return 总行数
     */
    long count(PackagesProject packagesProject);

    /**
     * 新增数据
     *
     * @param packagesProject 实例对象
     * @return 影响行数
     */
    int insert(PackagesProject packagesProject);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PackagesProject> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PackagesProject> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PackagesProject> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PackagesProject> entities);

    /**
     * 修改数据
     *
     * @param packagesProject 实例对象
     * @return 影响行数
     */
    int update(PackagesProject packagesProject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

