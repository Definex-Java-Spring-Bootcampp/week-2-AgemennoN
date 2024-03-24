package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.ProductType;
import java.math.BigDecimal;
import java.util.List;

public class CreditCard implements Product{

    private ProductType productType = ProductType.CreditCard; 
    private String name;
    private BigDecimal fee;
    private List<Campaign> campaignList;
    private String bankName;

    public CreditCard(String name, BigDecimal fee, List<Campaign> campaignList) {
        this.name = name;
        this.fee = fee;
        this.campaignList = campaignList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public ProductType getProductType() {
        return productType;
    }
    
    @Override
    public String toString() {
        return "CreditCard{" +
                "fee=" + fee +
                ", campaignList=" + campaignList +
                ", bank=" + bankName +
                '}';
    }
}
