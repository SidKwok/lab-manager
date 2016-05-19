package org.lab_manager.model;

import java.util.Date;

public class DeviceTypeInDto {
    private Integer id;

    private String assetName;

    private Integer classNo;

    private String className;

    private String originName;

    private String purchaseUnit;

    private String valueType;

    private Float unitPrice;

    private Integer number;

    private String invoiceNum;

    private String measurementUnit;

    private Date purchaseDate;

    private String financialRes;

    private String assetRes;

    private String handlePerson;

    private String chargeType;

    private Date checkDate;

    private Date receptDate;

    private String purchaseForm;

    private String managePart;

    private String subjectType;

    private String subject;

    private String remark;

    private String finantialOpinion;

    private String purchasingAgent;

    private String model;

    private String standard;

    private Date productionDate;

    private String country;

    private String manufacturer;

    private String brand;

    private Float power;

    private Date estimatedExpirationDate;

    private Integer durableYears;

    private String retailer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName == null ? null : originName.trim();
    }

    public String getPurchaseUnit() {
        return purchaseUnit;
    }

    public void setPurchaseUnit(String purchaseUnit) {
        this.purchaseUnit = purchaseUnit == null ? null : purchaseUnit.trim();
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType == null ? null : valueType.trim();
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum == null ? null : invoiceNum.trim();
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit == null ? null : measurementUnit.trim();
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getFinancialRes() {
        return financialRes;
    }

    public void setFinancialRes(String financialRes) {
        this.financialRes = financialRes == null ? null : financialRes.trim();
    }

    public String getAssetRes() {
        return assetRes;
    }

    public void setAssetRes(String assetRes) {
        this.assetRes = assetRes == null ? null : assetRes.trim();
    }

    public String getHandlePerson() {
        return handlePerson;
    }

    public void setHandlePerson(String handlePerson) {
        this.handlePerson = handlePerson == null ? null : handlePerson.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Date getReceptDate() {
        return receptDate;
    }

    public void setReceptDate(Date receptDate) {
        this.receptDate = receptDate;
    }

    public String getPurchaseForm() {
        return purchaseForm;
    }

    public void setPurchaseForm(String purchaseForm) {
        this.purchaseForm = purchaseForm == null ? null : purchaseForm.trim();
    }

    public String getManagePart() {
        return managePart;
    }

    public void setManagePart(String managePart) {
        this.managePart = managePart == null ? null : managePart.trim();
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType == null ? null : subjectType.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFinantialOpinion() {
        return finantialOpinion;
    }

    public void setFinantialOpinion(String finantialOpinion) {
        this.finantialOpinion = finantialOpinion == null ? null : finantialOpinion.trim();
    }

    public String getPurchasingAgent() {
        return purchasingAgent;
    }

    public void setPurchasingAgent(String purchasingAgent) {
        this.purchasingAgent = purchasingAgent == null ? null : purchasingAgent.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Date getEstimatedExpirationDate() {
        return estimatedExpirationDate;
    }

    public void setEstimatedExpirationDate(Date estimatedExpirationDate) {
        this.estimatedExpirationDate = estimatedExpirationDate;
    }

    public Integer getDurableYears() {
        return durableYears;
    }

    public void setDurableYears(Integer durableYears) {
        this.durableYears = durableYears;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer == null ? null : retailer.trim();
    }
}