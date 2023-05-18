package org.irecapi.service.impl;

import org.irecapi.entity.ContentEn;
import org.irecapi.dao.ContentEnDao;
import org.irecapi.service.ContentEnService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 内容en表(ContentEn)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 15:02:10
 */
@Service("contentEnService")
public class ContentEnServiceImpl implements ContentEnService {
    @Resource
    private ContentEnDao contentEnDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ContentEn queryById(Long id) {
        return this.contentEnDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param contentEn 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ContentEn> queryByPage(ContentEn contentEn, PageRequest pageRequest) {
        long total = this.contentEnDao.count(contentEn);
        return new PageImpl<>(this.contentEnDao.queryAllByLimit(contentEn, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param contentEn 实例对象
     * @return 实例对象
     */
    @Override
    public ContentEn insert(ContentEn contentEn) {
        this.contentEnDao.insert(contentEn);
        return contentEn;
    }

    /**
     * 修改数据
     *
     * @param contentEn 实例对象
     * @return 实例对象
     */
    @Override
    public ContentEn update(ContentEn contentEn) {
        this.contentEnDao.update(contentEn);
        return this.queryById(contentEn.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.contentEnDao.deleteById(id) > 0;
    }
}
