package org.irecapi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 注册结果表(RegistrationResult)实体类
 *
 * @author makejava
 * @since 2022-07-20 15:04:29
 */
public class RegistrationResult implements Serializable {
    private static final long serialVersionUID = 191034407503861560L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 注册项目包id
     */
    private Long packageId;
    /**
     * 状态（1通过，-1未通过）
     */
    private Integer status;
    /**
     * 注册人ID
     */
    private String registrationOrganizationIrecAccountId;
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 注册生效时间
     */
    private Date registrationEffectiveTime;
    /**
     * 接收账号
     */
    private String issueRecipientIrecAccountId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRegistrationOrganizationIrecAccountId() {
        return registrationOrganizationIrecAccountId;
    }

    public void setRegistrationOrganizationIrecAccountId(String registrationOrganizationIrecAccountId) {
        this.registrationOrganizationIrecAccountId = registrationOrganizationIrecAccountId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getRegistrationEffectiveTime() {
        return registrationEffectiveTime;
    }

    public void setRegistrationEffectiveTime(Date registrationEffectiveTime) {
        this.registrationEffectiveTime = registrationEffectiveTime;
    }

    public String getIssueRecipientIrecAccountId() {
        return issueRecipientIrecAccountId;
    }

    public void setIssueRecipientIrecAccountId(String issueRecipientIrecAccountId) {
        this.issueRecipientIrecAccountId = issueRecipientIrecAccountId;
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

