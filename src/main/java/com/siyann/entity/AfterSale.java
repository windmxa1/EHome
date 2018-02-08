package com.siyann.entity;

import javax.persistence.*;

@Entity
@Table(name = "after_sale", schema = "tendaehome", catalog = "")
public class AfterSale {
    private String afterSaleId;
    private long orderId;
    private String reason;
    private String handleResult;
    private String refundId;
    private long time;

    @Id
    @Column(name = "after_sale_id")
    public String getAfterSaleId() {
        return afterSaleId;
    }

    public void setAfterSaleId(String afterSaleId) {
        this.afterSaleId = afterSaleId;
    }

    @Basic
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "handle_result")
    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    @Basic
    @Column(name = "refund_id")
    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    @Basic
    @Column(name = "time")
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AfterSale afterSale = (AfterSale) o;

        if (orderId != afterSale.orderId) return false;
        if (time != afterSale.time) return false;
        if (afterSaleId != null ? !afterSaleId.equals(afterSale.afterSaleId) : afterSale.afterSaleId != null)
            return false;
        if (reason != null ? !reason.equals(afterSale.reason) : afterSale.reason != null) return false;
        if (handleResult != null ? !handleResult.equals(afterSale.handleResult) : afterSale.handleResult != null)
            return false;
        if (refundId != null ? !refundId.equals(afterSale.refundId) : afterSale.refundId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = afterSaleId != null ? afterSaleId.hashCode() : 0;
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (handleResult != null ? handleResult.hashCode() : 0);
        result = 31 * result + (refundId != null ? refundId.hashCode() : 0);
        result = 31 * result + (int) (time ^ (time >>> 32));
        return result;
    }
}
