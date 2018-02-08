package com.siyann.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Refund {
    private String refundId;
    private long orderId;
    private double refundFee;
    private Integer state;
    private String description;
    private Long time;

    @Id
    @Column(name = "refund_id")
    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
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
    @Column(name = "refund_fee")
    public double getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(double refundFee) {
        this.refundFee = refundFee;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "time")
    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Refund refund = (Refund) o;

        if (orderId != refund.orderId) return false;
        if (Double.compare(refund.refundFee, refundFee) != 0) return false;
        if (refundId != null ? !refundId.equals(refund.refundId) : refund.refundId != null) return false;
        if (state != null ? !state.equals(refund.state) : refund.state != null) return false;
        if (description != null ? !description.equals(refund.description) : refund.description != null) return false;
        if (time != null ? !time.equals(refund.time) : refund.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = refundId != null ? refundId.hashCode() : 0;
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        temp = Double.doubleToLongBits(refundFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
