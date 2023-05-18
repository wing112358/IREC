package org.irecapi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 项目包与项目关联表(PackagesProject)实体类
 *
 * @author makejava
 * @since 2022-07-20 15:02:56
 */
public class PackagesProject implements Serializable {
    private static final long serialVersionUID = -91285770712432543L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 包id
     */
    private Long packageId;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 是否为基准项目（0是，1否）
     */
    private Integer isStandard;
    /**
     * 是否删除（0未删除，1已删除），删除需同步包容量且状态回退
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getIsStandard() {
        return isStandard;
    }

    public void setIsStandard(Integer isStandard) {
        this.isStandard = isStandard;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}

