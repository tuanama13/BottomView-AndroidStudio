package com.example.ama.myapplication.Midtrans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("status_code")
    @Expose
    private String statusCode;
    @SerializedName("status_message")
    @Expose
    private String statusMessage;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("gross_amount")
    @Expose
    private String grossAmount;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("payment_type")
    @Expose
    private String paymentType;
    @SerializedName("transaction_time")
    @Expose
    private String transactionTime;
    @SerializedName("transaction_status")
    @Expose
    private String transactionStatus;
    @SerializedName("fraud_status")
    @Expose
    private String fraudStatus;
    @SerializedName("permata_va_number")
    @Expose
    private String permataVaNumber;
    @SerializedName("signature_key")
    @Expose
    private String signatureKey;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Data withStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Data withStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Data withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Data withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(String grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Data withGrossAmount(String grossAmount) {
        this.grossAmount = grossAmount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Data withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Data withPaymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Data withTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
        return this;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Data withTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public String getFraudStatus() {
        return fraudStatus;
    }

    public void setFraudStatus(String fraudStatus) {
        this.fraudStatus = fraudStatus;
    }

    public Data withFraudStatus(String fraudStatus) {
        this.fraudStatus = fraudStatus;
        return this;
    }

    public String getPermataVaNumber() {
        return permataVaNumber;
    }

    public void setPermataVaNumber(String permataVaNumber) {
        this.permataVaNumber = permataVaNumber;
    }

    public Data withPermataVaNumber(String permataVaNumber) {
        this.permataVaNumber = permataVaNumber;
        return this;
    }

    public String getSignatureKey() {
        return signatureKey;
    }

    public void setSignatureKey(String signatureKey) {
        this.signatureKey = signatureKey;
    }

    public Data withSignatureKey(String signatureKey) {
        this.signatureKey = signatureKey;
        return this;
    }
}
