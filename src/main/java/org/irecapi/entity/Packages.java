package org.irecapi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 打包表(Packages)实体类
 *
 * @author makejava
 * @since 2022-07-20 15:02:44
 */
public class Packages implements Serializable {
    private static final long serialVersionUID = -70081761370469335L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 装机容量（KW）
     */
    private Double capacity;
    /**
     * 能源类型
     */
    private String energyType;
    /**
     * 技术类型
     */
    private String technologyType;
    /**
     * 项目状态
     */
    private Integer status;
    /**
     * 注册日期
     */
    private Date registrationDate;
    /**
     * 打包信息的英译id
     */
    private Long contentEnId;
    /**
     * 创建者用户id
     */
    private Long creatorUserId;
    /**
     * 创建人姓名
     */
    private String creatorUserName;
    /**
     * 是否删除（0未删除，1已删除）
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getEnergyType() {
        return energyType;
    }

    public void setEnergyType(String energyType) {
        this.energyType = energyType;
    }

    public String getTechnologyType() {
        return technologyType;
    }

    public void setTechnologyType(String technologyType) {
        this.technologyType = technologyType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getContentEnId() {
        return contentEnId;
    }

    public void setContentEnId(Long contentEnId) {
        this.contentEnId = contentEnId;
    }

    public Long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Long creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
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

