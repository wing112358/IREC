package org.irecapi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 注册成果文件表(RegistrationDocuments)实体类
 *
 * @author makejava
 * @since 2022-07-20 15:04:05
 */
public class RegistrationDocuments implements Serializable {
    private static final long serialVersionUID = -71718551682640986L;
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
     * 文件类型（项目概要说明ove，项目注册登记表reg，可再生能源权属声明ten，设备所有权证明own，项目现场照片livePho，一次接线图line，现场消纳部分的电费结算清单bilCon，并网部分的电费结算清单bilGri，现场消纳部分的售电发票salCon，并网部分的售电发票salGri，授权文件auth）
     */
    private String type;
    /**
     * 签名类型（0不签名，1签名，2签章）
     */
    private Integer signatureType;
    /**
     * 文件名（中文）
     */
    private String nameCh;
    /**
     * 文件名（英文）
     */
    private String nameEn;
    /**
     * 文件路径
     */
    private String path;
    /**
     * 文件id
     */
    private Long fileId;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(Integer signatureType) {
        this.signatureType = signatureType;
    }

    public String getNameCh() {
        return nameCh;
    }

    public void setNameCh(String nameCh) {
        this.nameCh = nameCh;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
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

