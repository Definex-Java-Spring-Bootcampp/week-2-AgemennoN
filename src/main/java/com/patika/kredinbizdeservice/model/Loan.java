package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.ProductType;
import java.math.BigDecimal;

public abstract class Loan implements Product {

    private ProductType productType = ProductType.Loan;
    private BigDecimal amount;
    private Integer installment;
    private String bankName;
    private Double interestRate;
    // private Campaign campaign; // kampanyalı kredileri üstte çıkart

    //sponsorlu kampanyaları üstte çıkart

    public Loan() {
    }

    public Loan(BigDecimal amount, Integer installment, Double interestRate) {
        this.amount = amount;
        this.installment = installment;
        this.interestRate = interestRate;
    }

    abstract void calculate(BigDecimal amount, int installment);

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
    
    @Override
    public ProductType getProductType() {
        return productType;
    }
    
    @Override
    public String toString() {
        return "Loan{" +
                "amount=" + amount +
                ", installment=" + installment +
                ", bank=" + bankName +
                ", interestRate=" + interestRate +
                '}';
    }
}
