package org.irecapi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 项目表(Project)实体类
 *
 * @author makejava
 * @since 2022-07-20 15:03:10
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 993948290730531617L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目地址
     */
    private String address;
    /**
     * 能源类型（见字典表energyType）
     */
    private String energyType;
    /**
     * 技术类型（见字典表technologyType）
     */
    private String technologyType;
    /**
     * 项目状态（见字典表status）
     */
    private Integer status;
    /**
     * 装机容量（KW）
     */
    private Double capacity;
    /**
     * 投运日期
     */
    private Date deliveryDate;
    /**
     * 注册日期
     */
    private Date registrationDate;
    /**
     * 是否开发（0否，1是）
     */
    private Integer developFlag;
    /**
     * 已开发情况
     */
    private String developDesc;
    /**
     * 有无补贴（0无，1有）
     */
    private Integer subsidyFlag;
    /**
     * 是否并网（0否，1是）
     */
    private Integer gridConnectedFlag;
    /**
     * 并网电压（见字典表gridConnectedVoltageType）
     */
    private String gridConnectedVoltageType;
    /**
     * 并网方式
     */
    private String gridConnectedDesc;
    /**
     * 计量类型方式（见字典表measurementType）
     */
    private String measurementType;
    /**
     * 是否存在现场消纳（0否，1是）
     */
    private Integer siteConsumptionFlag;
    /**
     * 现场消纳情况
     */
    private String siteConsumptionDesc;
    /**
     * 现场消纳者是否还有辅助/备用电源（0否，1是）
     */
    private Integer siteConsumptionAuxiliaryPowerFlag;
    /**
     * 辅助/备用电源说明
     */
    private String siteConsumptionAuxiliaryPowerDesc;
    /**
     * 发电设施所有者名称
     */
    private String powerGenerationFacilityOwnerName;
    /**
     * 基本信息的英译id
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getDevelopFlag() {
        return developFlag;
    }

    public void setDevelopFlag(Integer developFlag) {
        this.developFlag = developFlag;
    }

    public String getDevelopDesc() {
        return developDesc;
    }

    public void setDevelopDesc(String developDesc) {
        this.developDesc = developDesc;
    }

    public Integer getSubsidyFlag() {
        return subsidyFlag;
    }

    public void setSubsidyFlag(Integer subsidyFlag) {
        this.subsidyFlag = subsidyFlag;
    }

    public Integer getGridConnectedFlag() {
        return gridConnectedFlag;
    }

    public void setGridConnectedFlag(Integer gridConnectedFlag) {
        this.gridConnectedFlag = gridConnectedFlag;
    }

    public String getGridConnectedVoltageType() {
        return gridConnectedVoltageType;
    }

    public void setGridConnectedVoltageType(String gridConnectedVoltageType) {
        this.gridConnectedVoltageType = gridConnectedVoltageType;
    }

    public String getGridConnectedDesc() {
        return gridConnectedDesc;
    }

    public void setGridConnectedDesc(String gridConnectedDesc) {
        this.gridConnectedDesc = gridConnectedDesc;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public Integer getSiteConsumptionFlag() {
        return siteConsumptionFlag;
    }

    public void setSiteConsumptionFlag(Integer siteConsumptionFlag) {
        this.siteConsumptionFlag = siteConsumptionFlag;
    }

    public String getSiteConsumptionDesc() {
        return siteConsumptionDesc;
    }

    public void setSiteConsumptionDesc(String siteConsumptionDesc) {
        this.siteConsumptionDesc = siteConsumptionDesc;
    }

    public Integer getSiteConsumptionAuxiliaryPowerFlag() {
        return siteConsumptionAuxiliaryPowerFlag;
    }

    public void setSiteConsumptionAuxiliaryPowerFlag(Integer siteConsumptionAuxiliaryPowerFlag) {
        this.siteConsumptionAuxiliaryPowerFlag = siteConsumptionAuxiliaryPowerFlag;
    }

    public String getSiteConsumptionAuxiliaryPowerDesc() {
        return siteConsumptionAuxiliaryPowerDesc;
    }

    public void setSiteConsumptionAuxiliaryPowerDesc(String siteConsumptionAuxiliaryPowerDesc) {
        this.siteConsumptionAuxiliaryPowerDesc = siteConsumptionAuxiliaryPowerDesc;
    }

    public String getPowerGenerationFacilityOwnerName() {
        return powerGenerationFacilityOwnerName;
    }

    public void setPowerGenerationFacilityOwnerName(String powerGenerationFacilityOwnerName) {
        this.powerGenerationFacilityOwnerName = powerGenerationFacilityOwnerName;
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

