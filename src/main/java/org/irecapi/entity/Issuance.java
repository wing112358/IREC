package org.irecapi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 签发记录表(Issuance)实体类
 *
 * @author makejava
 * @since 2023-05-24 17:36:45
 */
public class Issuance implements Serializable {
    private static final long serialVersionUID = 408754489192784979L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 项目id
     */
    private Long packageId;
    /**
     * 项目名称
     */
    private String packageName;
    /**
     * 签发状态（见字典表issuanceStatus）
     */
    private Integer status;
    /**
     * 签发类型（见字典表planIssuanceType）
     */
    private String type;
    /**
     * 签发起始时间
     */
    private Date issuanceTimeStart;
    /**
     * 签发终止时间
     */
    private Date issuanceTimeEnd;
    /**
     * 签发月范围（属冗余字段，方便计算可签发日期）
     */
    private String issuanceTimeRange;
    /**
     * 签发电量（kWh）
     */
    private Double issuedQuantity;
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

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getIssuanceTimeStart() {
        return issuanceTimeStart;
    }

    public void setIssuanceTimeStart(Date issuanceTimeStart) {
        this.issuanceTimeStart = issuanceTimeStart;
    }

    public Date getIssuanceTimeEnd() {
        return issuanceTimeEnd;
    }

    public void setIssuanceTimeEnd(Date issuanceTimeEnd) {
        this.issuanceTimeEnd = issuanceTimeEnd;
    }

    public String getIssuanceTimeRange() {
        return issuanceTimeRange;
    }

    public void setIssuanceTimeRange(String issuanceTimeRange) {
        this.issuanceTimeRange = issuanceTimeRange;
    }

    public Double getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(Double issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
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

