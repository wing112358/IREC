package org.irecapi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 注册成果文件导出记录表(RegistrationDocumentsExportLog)实体类
 *
 * @author makejava
 * @since 2022-07-20 15:04:19
 */
public class RegistrationDocumentsExportLog implements Serializable {
    private static final long serialVersionUID = -69400967188139327L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 包id
     */
    private Long packageId;
    /**
     * 注册成果文件ids
     */
    private String registrationDocumentsIds;
    /**
     * 状态（0导出中，1已导出，-1导出失败）
     */
    private Integer status;
    /**
     * 是否删除（0未删除，1已删除）
     */
    private Integer isDelete;
    /**
     * 创建者用户id
     */
    private Long createdBy;
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

    public String getRegistrationDocumentsIds() {
        return registrationDocumentsIds;
    }

    public void setRegistrationDocumentsIds(String registrationDocumentsIds) {
        this.registrationDocumentsIds = registrationDocumentsIds;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
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

