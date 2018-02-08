package com.siyann.view;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "v_orders", schema = "tendaehome", catalog = "")
public class VOrders {
    private long id;
    private long userid;
    private long time;
    private Integer isExport;
    private Integer payWay;
    private Integer deliveryState;
    private String refundId;
    private Integer afterSaleState;
    private Long franchiseeId;
    private Integer type;
    private String remarks;
    private String address;
    private String orderNum;
    private Integer isComment;
    private BigDecimal total;
    private Long num;
    private String franchiseeName;
    private String staffName;
    private String createTime;
    private Integer state;
    private String status;

    @Basic
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "is_export")
    public Integer getIsExport() {
        return isExport;
    }

    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
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
    @Column(name = "delivery_state")
    public Integer getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "is_comment")
    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    @Basic
    @Column(name = "total")
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Basic
    @Column(name = "num")
    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Basic
    @Column(name = "franchisee_name")
    public String getFranchiseeName() {
        return franchiseeName;
    }

    public void setFranchiseeName(String franchiseeName) {
        this.franchiseeName = franchiseeName;
    }

    @Basic
    @Column(name = "staff_name")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Basic
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VOrders vOrders = (VOrders) o;

        if (id != vOrders.id) return false;
        if (userid != vOrders.userid) return false;
        if (time != vOrders.time) return false;
        if (isExport != null ? !isExport.equals(vOrders.isExport) : vOrders.isExport != null) return false;
        if (payWay != null ? !payWay.equals(vOrders.payWay) : vOrders.payWay != null) return false;
        if (deliveryState != null ? !deliveryState.equals(vOrders.deliveryState) : vOrders.deliveryState != null)
            return false;
        if (refundId != null ? !refundId.equals(vOrders.refundId) : vOrders.refundId != null) return false;
        if (afterSaleState != null ? !afterSaleState.equals(vOrders.afterSaleState) : vOrders.afterSaleState != null)
            return false;
        if (franchiseeId != null ? !franchiseeId.equals(vOrders.franchiseeId) : vOrders.franchiseeId != null)
            return false;
        if (type != null ? !type.equals(vOrders.type) : vOrders.type != null) return false;
        if (remarks != null ? !remarks.equals(vOrders.remarks) : vOrders.remarks != null) return false;
        if (address != null ? !address.equals(vOrders.address) : vOrders.address != null) return false;
        if (orderNum != null ? !orderNum.equals(vOrders.orderNum) : vOrders.orderNum != null) return false;
        if (isComment != null ? !isComment.equals(vOrders.isComment) : vOrders.isComment != null) return false;
        if (total != null ? !total.equals(vOrders.total) : vOrders.total != null) return false;
        if (num != null ? !num.equals(vOrders.num) : vOrders.num != null) return false;
        if (franchiseeName != null ? !franchiseeName.equals(vOrders.franchiseeName) : vOrders.franchiseeName != null)
            return false;
        if (staffName != null ? !staffName.equals(vOrders.staffName) : vOrders.staffName != null) return false;
        if (createTime != null ? !createTime.equals(vOrders.createTime) : vOrders.createTime != null) return false;
        if (state != null ? !state.equals(vOrders.state) : vOrders.state != null) return false;
        if (status != null ? !status.equals(vOrders.status) : vOrders.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userid ^ (userid >>> 32));
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (isExport != null ? isExport.hashCode() : 0);
        result = 31 * result + (payWay != null ? payWay.hashCode() : 0);
        result = 31 * result + (deliveryState != null ? deliveryState.hashCode() : 0);
        result = 31 * result + (refundId != null ? refundId.hashCode() : 0);
        result = 31 * result + (afterSaleState != null ? afterSaleState.hashCode() : 0);
        result = 31 * result + (franchiseeId != null ? franchiseeId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        result = 31 * result + (isComment != null ? isComment.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (franchiseeName != null ? franchiseeName.hashCode() : 0);
        result = 31 * result + (staffName != null ? staffName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
