package org.irecapi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 项目注册资料表(ProjectRegistrationData)实体类
 *
 * @author makejava
 * @since 2022-07-20 15:03:50
 */
public class ProjectRegistrationData implements Serializable {
    private static final long serialVersionUID = 820615779864887369L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 发电设施所在位置
     */
    private String powerGenerationFacilitiesAddress;
    /**
     * 发电设施所在位置的经纬度坐标
     */
    private String powerGenerationFacilitiesAddressLanLon;
    /**
     * 发电设施所在位置的截图
     */
    private String powerGenerationFacilitiesAddressScreenshot;
    /**
     * 发电设施所在位置的截图文字说明
     */
    private String powerGenerationFacilitiesAddressScreenshotDesc;
    /**
     * 发电设施所在位置的截图文字说明的英译
     */
    private String powerGenerationFacilitiesAddressScreenshotDescEn;
    /**
     * 现场全景照
     */
    private String sitePhoto;
    /**
     * 现场近景照
     */
    private String siteNearPhoto;
    /**
     * 现场门头照
     */
    private String siteDoorPhoto;
    /**
     * 合同
     */
    private String contract;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 发电设施所有者名称
     */
    private String powerGenerationFacilityOwnerName;
    /**
     * 现场消纳者名称
     */
    private String siteConsumerName;
    /**
     * 电网运营者名称
     */
    private String gridOperatorName;
    /**
     * 合同关键信息的英译
     */
    private String contractKeyInfoEn;
    /**
     * 合同截图
     */
    private String contractScreenshot;
    /**
     * 合同截图文字说明
     */
    private String contractScreenshotDesc;
    /**
     * 合同截图文字说明的英译
     */
    private String contractScreenshotDescEn;
    /**
     * 一次接线图
     */
    private String primaryWiringDiagram;
    /**
     * 装机容量（KW）
     */
    private Double capacity;
    /**
     * 现场消纳部分的电费结算清单
     */
    private String siteConsumptiveElectricityList;
    /**
     * 现场消纳部分的售电发票/备用电源说明
     */
    private String siteConsumptiveElectricitySalesInvoice;
    /**
     * 并网部分的电费结算清单
     */
    private String gridConnectedElectricityList;
    /**
     * 并网部分的售电发票
     */
    private String gridConnectedElectricitySalesInvoice;
    /**
     * 电能表（电能表ID，电能表类型（见字典表meterType），电能表计量类型（见字典表meterMeasurementType））
     */
    private String meter;
    /**
     * 现场消纳部分的电费结算清单截图
     */
    private String siteConsumptiveElectricityListScreenshot;
    /**
     * 现场消纳部分的电费结算清单截图说明文字
     */
    private String siteConsumptiveElectricityListScreenshotDesc;
    /**
     * 现场消纳部分的电费结算清单截图说明文字的英译
     */
    private String siteConsumptiveElectricityListScreenshotDescEn;
    /**
     * 现场消纳部分的售电发票截图
     */
    private String siteConsumptiveElectricitySalesInvoiceScreenshot;
    /**
     * 现场消纳部分的售电发票截图说明文字
     */
    private String siteConsumptiveElectricitySalesInvoiceScreenshotDesc;
    /**
     * 现场消纳部分的售电发票截图说明文字的英译
     */
    private String siteConsumptiveElectricitySalesInvoiceScreenshotDescEn;
    /**
     * 并网部分的电费结算清单截图
     */
    private String gridConnectedElectricityListScreenshot;
    /**
     * 并网部分的电费结算清单截图说明文字
     */
    private String gridConnectedElectricityListScreenshotDesc;
    /**
     * 并网部分的电费结算清单截图说明文字的英译
     */
    private String gridConnectedElectricityListScreenshotDescEn;
    /**
     * 并网部分的售电发票截图
     */
    private String gridConnectedElectricitySalesInvoiceScreenshot;
    /**
     * 并网部分的售电发票截图说明文字
     */
    private String gridConnectedElectricitySalesInvoiceScreenshotDesc;
    /**
     * 并网部分的售电发票截图说明文字的英译
     */
    private String gridConnectedElectricitySalesInvoiceScreenshotDescEn;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getPowerGenerationFacilitiesAddress() {
        return powerGenerationFacilitiesAddress;
    }

    public void setPowerGenerationFacilitiesAddress(String powerGenerationFacilitiesAddress) {
        this.powerGenerationFacilitiesAddress = powerGenerationFacilitiesAddress;
    }

    public String getPowerGenerationFacilitiesAddressLanLon() {
        return powerGenerationFacilitiesAddressLanLon;
    }

    public void setPowerGenerationFacilitiesAddressLanLon(String powerGenerationFacilitiesAddressLanLon) {
        this.powerGenerationFacilitiesAddressLanLon = powerGenerationFacilitiesAddressLanLon;
    }

    public String getPowerGenerationFacilitiesAddressScreenshot() {
        return powerGenerationFacilitiesAddressScreenshot;
    }

    public void setPowerGenerationFacilitiesAddressScreenshot(String powerGenerationFacilitiesAddressScreenshot) {
        this.powerGenerationFacilitiesAddressScreenshot = powerGenerationFacilitiesAddressScreenshot;
    }

    public String getPowerGenerationFacilitiesAddressScreenshotDesc() {
        return powerGenerationFacilitiesAddressScreenshotDesc;
    }

    public void setPowerGenerationFacilitiesAddressScreenshotDesc(String powerGenerationFacilitiesAddressScreenshotDesc) {
        this.powerGenerationFacilitiesAddressScreenshotDesc = powerGenerationFacilitiesAddressScreenshotDesc;
    }

    public String getPowerGenerationFacilitiesAddressScreenshotDescEn() {
        return powerGenerationFacilitiesAddressScreenshotDescEn;
    }

    public void setPowerGenerationFacilitiesAddressScreenshotDescEn(String powerGenerationFacilitiesAddressScreenshotDescEn) {
        this.powerGenerationFacilitiesAddressScreenshotDescEn = powerGenerationFacilitiesAddressScreenshotDescEn;
    }

    public String getSitePhoto() {
        return sitePhoto;
    }

    public void setSitePhoto(String sitePhoto) {
        this.sitePhoto = sitePhoto;
    }

    public String getSiteNearPhoto() {
        return siteNearPhoto;
    }

    public void setSiteNearPhoto(String siteNearPhoto) {
        this.siteNearPhoto = siteNearPhoto;
    }

    public String getSiteDoorPhoto() {
        return siteDoorPhoto;
    }

    public void setSiteDoorPhoto(String siteDoorPhoto) {
        this.siteDoorPhoto = siteDoorPhoto;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPowerGenerationFacilityOwnerName() {
        return powerGenerationFacilityOwnerName;
    }

    public void setPowerGenerationFacilityOwnerName(String powerGenerationFacilityOwnerName) {
        this.powerGenerationFacilityOwnerName = powerGenerationFacilityOwnerName;
    }

    public String getSiteConsumerName() {
        return siteConsumerName;
    }

    public void setSiteConsumerName(String siteConsumerName) {
        this.siteConsumerName = siteConsumerName;
    }

    public String getGridOperatorName() {
        return gridOperatorName;
    }

    public void setGridOperatorName(String gridOperatorName) {
        this.gridOperatorName = gridOperatorName;
    }

    public String getContractKeyInfoEn() {
        return contractKeyInfoEn;
    }

    public void setContractKeyInfoEn(String contractKeyInfoEn) {
        this.contractKeyInfoEn = contractKeyInfoEn;
    }

    public String getContractScreenshot() {
        return contractScreenshot;
    }

    public void setContractScreenshot(String contractScreenshot) {
        this.contractScreenshot = contractScreenshot;
    }

    public String getContractScreenshotDesc() {
        return contractScreenshotDesc;
    }

    public void setContractScreenshotDesc(String contractScreenshotDesc) {
        this.contractScreenshotDesc = contractScreenshotDesc;
    }

    public String getContractScreenshotDescEn() {
        return contractScreenshotDescEn;
    }

    public void setContractScreenshotDescEn(String contractScreenshotDescEn) {
        this.contractScreenshotDescEn = contractScreenshotDescEn;
    }

    public String getPrimaryWiringDiagram() {
        return primaryWiringDiagram;
    }

    public void setPrimaryWiringDiagram(String primaryWiringDiagram) {
        this.primaryWiringDiagram = primaryWiringDiagram;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getSiteConsumptiveElectricityList() {
        return siteConsumptiveElectricityList;
    }

    public void setSiteConsumptiveElectricityList(String siteConsumptiveElectricityList) {
        this.siteConsumptiveElectricityList = siteConsumptiveElectricityList;
    }

    public String getSiteConsumptiveElectricitySalesInvoice() {
        return siteConsumptiveElectricitySalesInvoice;
    }

    public void setSiteConsumptiveElectricitySalesInvoice(String siteConsumptiveElectricitySalesInvoice) {
        this.siteConsumptiveElectricitySalesInvoice = siteConsumptiveElectricitySalesInvoice;
    }

    public String getGridConnectedElectricityList() {
        return gridConnectedElectricityList;
    }

    public void setGridConnectedElectricityList(String gridConnectedElectricityList) {
        this.gridConnectedElectricityList = gridConnectedElectricityList;
    }

    public String getGridConnectedElectricitySalesInvoice() {
        return gridConnectedElectricitySalesInvoice;
    }

    public void setGridConnectedElectricitySalesInvoice(String gridConnectedElectricitySalesInvoice) {
        this.gridConnectedElectricitySalesInvoice = gridConnectedElectricitySalesInvoice;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public String getSiteConsumptiveElectricityListScreenshot() {
        return siteConsumptiveElectricityListScreenshot;
    }

    public void setSiteConsumptiveElectricityListScreenshot(String siteConsumptiveElectricityListScreenshot) {
        this.siteConsumptiveElectricityListScreenshot = siteConsumptiveElectricityListScreenshot;
    }

    public String getSiteConsumptiveElectricityListScreenshotDesc() {
        return siteConsumptiveElectricityListScreenshotDesc;
    }

    public void setSiteConsumptiveElectricityListScreenshotDesc(String siteConsumptiveElectricityListScreenshotDesc) {
        this.siteConsumptiveElectricityListScreenshotDesc = siteConsumptiveElectricityListScreenshotDesc;
    }

    public String getSiteConsumptiveElectricityListScreenshotDescEn() {
        return siteConsumptiveElectricityListScreenshotDescEn;
    }

    public void setSiteConsumptiveElectricityListScreenshotDescEn(String siteConsumptiveElectricityListScreenshotDescEn) {
        this.siteConsumptiveElectricityListScreenshotDescEn = siteConsumptiveElectricityListScreenshotDescEn;
    }

    public String getSiteConsumptiveElectricitySalesInvoiceScreenshot() {
        return siteConsumptiveElectricitySalesInvoiceScreenshot;
    }

    public void setSiteConsumptiveElectricitySalesInvoiceScreenshot(String siteConsumptiveElectricitySalesInvoiceScreenshot) {
        this.siteConsumptiveElectricitySalesInvoiceScreenshot = siteConsumptiveElectricitySalesInvoiceScreenshot;
    }

    public String getSiteConsumptiveElectricitySalesInvoiceScreenshotDesc() {
        return siteConsumptiveElectricitySalesInvoiceScreenshotDesc;
    }

    public void setSiteConsumptiveElectricitySalesInvoiceScreenshotDesc(String siteConsumptiveElectricitySalesInvoiceScreenshotDesc) {
        this.siteConsumptiveElectricitySalesInvoiceScreenshotDesc = siteConsumptiveElectricitySalesInvoiceScreenshotDesc;
    }

    public String getSiteConsumptiveElectricitySalesInvoiceScreenshotDescEn() {
        return siteConsumptiveElectricitySalesInvoiceScreenshotDescEn;
    }

    public void setSiteConsumptiveElectricitySalesInvoiceScreenshotDescEn(String siteConsumptiveElectricitySalesInvoiceScreenshotDescEn) {
        this.siteConsumptiveElectricitySalesInvoiceScreenshotDescEn = siteConsumptiveElectricitySalesInvoiceScreenshotDescEn;
    }

    public String getGridConnectedElectricityListScreenshot() {
        return gridConnectedElectricityListScreenshot;
    }

    public void setGridConnectedElectricityListScreenshot(String gridConnectedElectricityListScreenshot) {
        this.gridConnectedElectricityListScreenshot = gridConnectedElectricityListScreenshot;
    }

    public String getGridConnectedElectricityListScreenshotDesc() {
        return gridConnectedElectricityListScreenshotDesc;
    }

    public void setGridConnectedElectricityListScreenshotDesc(String gridConnectedElectricityListScreenshotDesc) {
        this.gridConnectedElectricityListScreenshotDesc = gridConnectedElectricityListScreenshotDesc;
    }

    public String getGridConnectedElectricityListScreenshotDescEn() {
        return gridConnectedElectricityListScreenshotDescEn;
    }

    public void setGridConnectedElectricityListScreenshotDescEn(String gridConnectedElectricityListScreenshotDescEn) {
        this.gridConnectedElectricityListScreenshotDescEn = gridConnectedElectricityListScreenshotDescEn;
    }

    public String getGridConnectedElectricitySalesInvoiceScreenshot() {
        return gridConnectedElectricitySalesInvoiceScreenshot;
    }

    public void setGridConnectedElectricitySalesInvoiceScreenshot(String gridConnectedElectricitySalesInvoiceScreenshot) {
        this.gridConnectedElectricitySalesInvoiceScreenshot = gridConnectedElectricitySalesInvoiceScreenshot;
    }

    public String getGridConnectedElectricitySalesInvoiceScreenshotDesc() {
        return gridConnectedElectricitySalesInvoiceScreenshotDesc;
    }

    public void setGridConnectedElectricitySalesInvoiceScreenshotDesc(String gridConnectedElectricitySalesInvoiceScreenshotDesc) {
        this.gridConnectedElectricitySalesInvoiceScreenshotDesc = gridConnectedElectricitySalesInvoiceScreenshotDesc;
    }

    public String getGridConnectedElectricitySalesInvoiceScreenshotDescEn() {
        return gridConnectedElectricitySalesInvoiceScreenshotDescEn;
    }

    public void setGridConnectedElectricitySalesInvoiceScreenshotDescEn(String gridConnectedElectricitySalesInvoiceScreenshotDescEn) {
        this.gridConnectedElectricitySalesInvoiceScreenshotDescEn = gridConnectedElectricitySalesInvoiceScreenshotDescEn;
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

