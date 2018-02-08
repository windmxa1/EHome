package com.siyann.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {
    private long id;
    private String orderNum;
    private long userid;
    private long time;
    private String address;
    private String staffNo;
    private Integer isExport;
    private Integer deliveryState;
    private Integer payWay;
    private String refundId;
    private Long finishTime;
    private Integer afterSaleState;
    private Long franchiseeId;
    private Integer type;
    private String remarks;
    private Integer isComment;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_num")
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "userid")
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "time")
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "staff_no")
    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    @Basic
    @Column(name = "is_export")
    public Integer getIsExport() {
        return isExport;
    }

    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
    }

    @Basic
    @Column(name = "delivery_state")
    public Integer getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
    }

    @Basic
    @Column(name = "pay_way")
    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
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
    @Column(name = "finish_time")
    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "after_sale_state")
    public Integer getAfterSaleState() {
        return afterSaleState;
    }

    public void setAfterSaleState(Integer afterSaleState) {
        this.afterSaleState = afterSaleState;
    }

    @Basic
    @Column(name = "franchisee_id")
    public Long getFranchiseeId() {
        return franchiseeId;
    }

    public void setFranchiseeId(Long franchiseeId) {
        this.franchiseeId = franchiseeId;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "is_comment")
    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (userid != orders.userid) return false;
        if (time != orders.time) return false;
        if (orderNum != null ? !orderNum.equals(orders.orderNum) : orders.orderNum != null) return false;
        if (address != null ? !address.equals(orders.address) : orders.address != null) return false;
        if (staffNo != null ? !staffNo.equals(orders.staffNo) : orders.staffNo != null) return false;
        if (isExport != null ? !isExport.equals(orders.isExport) : orders.isExport != null) return false;
        if (deliveryState != null ? !deliveryState.equals(orders.deliveryState) : orders.deliveryState != null)
            return false;
        if (payWay != null ? !payWay.equals(orders.payWay) : orders.payWay != null) return false;
        if (refundId != null ? !refundId.equals(orders.refundId) : orders.refundId != null) return false;
        if (finishTime != null ? !finishTime.equals(orders.finishTime) : orders.finishTime != null) return false;
        if (afterSaleState != null ? !afterSaleState.equals(orders.afterSaleState) : orders.afterSaleState != null)
            return false;
        if (franchiseeId != null ? !franchiseeId.equals(orders.franchiseeId) : orders.franchiseeId != null)
            return false;
        if (type != null ? !type.equals(orders.type) : orders.type != null) return false;
        if (remarks != null ? !remarks.equals(orders.remarks) : orders.remarks != null) return false;
        if (isComment != null ? !isComment.equals(orders.isComment) : orders.isComment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        result = 31 * result + (int) (userid ^ (userid >>> 32));
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (staffNo != null ? staffNo.hashCode() : 0);
        result = 31 * result + (isExport != null ? isExport.hashCode() : 0);
        result = 31 * result + (deliveryState != null ? deliveryState.hashCode() : 0);
        result = 31 * result + (payWay != null ? payWay.hashCode() : 0);
        result = 31 * result + (refundId != null ? refundId.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (afterSaleState != null ? afterSaleState.hashCode() : 0);
        result = 31 * result + (franchiseeId != null ? franchiseeId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (isComment != null ? isComment.hashCode() : 0);
        return result;
    }
}
