package org.irecapi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 组织扩展信息表(CustomerInfoEx)实体类
 *
 * @author makejava
 * @since 2022-07-20 15:02:30
 */
public class CustomerInfoEx implements Serializable {
    private static final long serialVersionUID = 678941457001907959L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 组织id
     */
    private Long customerId;
    /**
     * 注册机构名称
     */
    private String registrationOrganizationName;
    /**
     * 注册机构地址（区县）
     */
    private String registrationOrganizationAddressArea;
    /**
     * 注册机构地址（街道）
     */
    private String registrationOrganizationAddressStreet;
    /**
     * 注册机构地址（门牌号、楼栋、房间号）
     */
    private String registrationOrganizationAddressNum;
    /**
     * 注册机构邮政编码
     */
    private String registrationOrganizationPostalCode;
    /**
     * 注册机构账号ID
     */
    private String registrationOrganizationIrecAccountId;
    /**
     * 注册机构代理人姓名
     */
    private String registrationOrganizationAgentName;
    /**
     * 注册机构代理人联系电话
     */
    private String registrationOrganizationAgentContactPhone;
    /**
     * 注册机构代理人电子邮箱
     */
    private String registrationOrganizationAgentEmail;
    /**
     * 注册机构代理人签名
     */
    private String registrationOrganizationAgentContactSignature;
    /**
     * 注册机构代理人职位
     */
    private String registrationOrganizationAgentPosition;
    /**
     * 项目持有机构名称
     */
    private String projectHolderName;
    /**
     * 项目持有机构地址（国家、省/直辖市、市/区县）
     */
    private String projectHolderAddressArea;
    /**
     * 项目持有机构地址（街道）
     */
    private String projectHolderAddressStreet;
    /**
     * 项目持有机构地址（门牌号、楼栋、房间号）
     */
    private String projectHolderAddressNum;
    /**
     * 项目持有机构邮政编码
     */
    private String projectHolderPostalCode;
    /**
     * 项目持有机构代理人姓名
     */
    private String projectHolderAgentName;
    /**
     * 项目持有机构代理人联系电话
     */
    private String projectHolderAgentContactPhone;
    /**
     * 项目持有机构代理人电子邮箱
     */
    private String projectHolderAgentEmail;
    /**
     * 项目持有机构代理人代理人签章
     */
    private String projectHolderAgentContactSignature;
    /**
     * 项目持有机构代理人授权文件
     */
    private String projectHolderAgentAuthorizationAttachment;
    /**
     * 签发接收人名称
     */
    private String issuingRecipientName;
    /**
     * 签发接收人账号ID
     */
    private String issueRecipientIrecAccountId;
    /**
     * 英文内容id
     */
    private Long contentEnId;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getRegistrationOrganizationName() {
        return registrationOrganizationName;
    }

    public void setRegistrationOrganizationName(String registrationOrganizationName) {
        this.registrationOrganizationName = registrationOrganizationName;
    }

    public String getRegistrationOrganizationAddressArea() {
        return registrationOrganizationAddressArea;
    }

    public void setRegistrationOrganizationAddressArea(String registrationOrganizationAddressArea) {
        this.registrationOrganizationAddressArea = registrationOrganizationAddressArea;
    }

    public String getRegistrationOrganizationAddressStreet() {
        return registrationOrganizationAddressStreet;
    }

    public void setRegistrationOrganizationAddressStreet(String registrationOrganizationAddressStreet) {
        this.registrationOrganizationAddressStreet = registrationOrganizationAddressStreet;
    }

    public String getRegistrationOrganizationAddressNum() {
        return registrationOrganizationAddressNum;
    }

    public void setRegistrationOrganizationAddressNum(String registrationOrganizationAddressNum) {
        this.registrationOrganizationAddressNum = registrationOrganizationAddressNum;
    }

    public String getRegistrationOrganizationPostalCode() {
        return registrationOrganizationPostalCode;
    }

    public void setRegistrationOrganizationPostalCode(String registrationOrganizationPostalCode) {
        this.registrationOrganizationPostalCode = registrationOrganizationPostalCode;
    }

    public String getRegistrationOrganizationIrecAccountId() {
        return registrationOrganizationIrecAccountId;
    }

    public void setRegistrationOrganizationIrecAccountId(String registrationOrganizationIrecAccountId) {
        this.registrationOrganizationIrecAccountId = registrationOrganizationIrecAccountId;
    }

    public String getRegistrationOrganizationAgentName() {
        return registrationOrganizationAgentName;
    }

    public void setRegistrationOrganizationAgentName(String registrationOrganizationAgentName) {
        this.registrationOrganizationAgentName = registrationOrganizationAgentName;
    }

    public String getRegistrationOrganizationAgentContactPhone() {
        return registrationOrganizationAgentContactPhone;
    }

    public void setRegistrationOrganizationAgentContactPhone(String registrationOrganizationAgentContactPhone) {
        this.registrationOrganizationAgentContactPhone = registrationOrganizationAgentContactPhone;
    }

    public String getRegistrationOrganizationAgentEmail() {
        return registrationOrganizationAgentEmail;
    }

    public void setRegistrationOrganizationAgentEmail(String registrationOrganizationAgentEmail) {
        this.registrationOrganizationAgentEmail = registrationOrganizationAgentEmail;
    }

    public String getRegistrationOrganizationAgentContactSignature() {
        return registrationOrganizationAgentContactSignature;
    }

    public void setRegistrationOrganizationAgentContactSignature(String registrationOrganizationAgentContactSignature) {
        this.registrationOrganizationAgentContactSignature = registrationOrganizationAgentContactSignature;
    }

    public String getRegistrationOrganizationAgentPosition() {
        return registrationOrganizationAgentPosition;
    }

    public void setRegistrationOrganizationAgentPosition(String registrationOrganizationAgentPosition) {
        this.registrationOrganizationAgentPosition = registrationOrganizationAgentPosition;
    }

    public String getProjectHolderName() {
        return projectHolderName;
    }

    public void setProjectHolderName(String projectHolderName) {
        this.projectHolderName = projectHolderName;
    }

    public String getProjectHolderAddressArea() {
        return projectHolderAddressArea;
    }

    public void setProjectHolderAddressArea(String projectHolderAddressArea) {
        this.projectHolderAddressArea = projectHolderAddressArea;
    }

    public String getProjectHolderAddressStreet() {
        return projectHolderAddressStreet;
    }

    public void setProjectHolderAddressStreet(String projectHolderAddressStreet) {
        this.projectHolderAddressStreet = projectHolderAddressStreet;
    }

    public String getProjectHolderAddressNum() {
        return projectHolderAddressNum;
    }

    public void setProjectHolderAddressNum(String projectHolderAddressNum) {
        this.projectHolderAddressNum = projectHolderAddressNum;
    }

    public String getProjectHolderPostalCode() {
        return projectHolderPostalCode;
    }

    public void setProjectHolderPostalCode(String projectHolderPostalCode) {
        this.projectHolderPostalCode = projectHolderPostalCode;
    }

    public String getProjectHolderAgentName() {
        return projectHolderAgentName;
    }

    public void setProjectHolderAgentName(String projectHolderAgentName) {
        this.projectHolderAgentName = projectHolderAgentName;
    }

    public String getProjectHolderAgentContactPhone() {
        return projectHolderAgentContactPhone;
    }

    public void setProjectHolderAgentContactPhone(String projectHolderAgentContactPhone) {
        this.projectHolderAgentContactPhone = projectHolderAgentContactPhone;
    }

    public String getProjectHolderAgentEmail() {
        return projectHolderAgentEmail;
    }

    public void setProjectHolderAgentEmail(String projectHolderAgentEmail) {
        this.projectHolderAgentEmail = projectHolderAgentEmail;
    }

    public String getProjectHolderAgentContactSignature() {
        return projectHolderAgentContactSignature;
    }

    public void setProjectHolderAgentContactSignature(String projectHolderAgentContactSignature) {
        this.projectHolderAgentContactSignature = projectHolderAgentContactSignature;
    }

    public String getProjectHolderAgentAuthorizationAttachment() {
        return projectHolderAgentAuthorizationAttachment;
    }

    public void setProjectHolderAgentAuthorizationAttachment(String projectHolderAgentAuthorizationAttachment) {
        this.projectHolderAgentAuthorizationAttachment = projectHolderAgentAuthorizationAttachment;
    }

    public String getIssuingRecipientName() {
        return issuingRecipientName;
    }

    public void setIssuingRecipientName(String issuingRecipientName) {
        this.issuingRecipientName = issuingRecipientName;
    }

    public String getIssueRecipientIrecAccountId() {
        return issueRecipientIrecAccountId;
    }

    public void setIssueRecipientIrecAccountId(String issueRecipientIrecAccountId) {
        this.issueRecipientIrecAccountId = issueRecipientIrecAccountId;
    }

    public Long getContentEnId() {
        return contentEnId;
    }

    public void setContentEnId(Long contentEnId) {
        this.contentEnId = contentEnId;
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

