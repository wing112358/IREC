package org.irecapi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.irecapi.entity.ContentEn;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 内容en表(ContentEn)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 15:02:08
 */

@Mapper
public interface ContentEnDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ContentEn queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param contentEn 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ContentEn> queryAllByLimit(ContentEn contentEn, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param contentEn 查询条件
     * @return 总行数
     */
    long count(ContentEn contentEn);

    /**
     * 新增数据
     *
     * @param contentEn 实例对象
     * @return 影响行数
     */
    int insert(ContentEn contentEn);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ContentEn> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ContentEn> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ContentEn> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ContentEn> entities);

    /**
     * 修改数据
     *
     * @param contentEn 实例对象
     * @return 影响行数
     */
    int update(ContentEn contentEn);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

