package cn.com.pro.vo;

import java.io.Serializable;
import java.util.Date;

public class OrderInf implements Serializable {
    private Integer orderId;

    private Integer orderSn;

    private Integer customerId;

    private String shippingCompName;

    private String shippingSn;

    private Date createTime;

    private Date shippingTime;

    private Date receiveTime;

    private Integer orderStatus;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(Integer orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getShippingCompName() {
        return shippingCompName;
    }

    public void setShippingCompName(String shippingCompName) {
        this.shippingCompName = shippingCompName == null ? null : shippingCompName.trim();
    }

    public String getShippingSn() {
        return shippingSn;
    }

    public void setShippingSn(String shippingSn) {
        this.shippingSn = shippingSn == null ? null : shippingSn.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderInf other = (OrderInf) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getShippingCompName() == null ? other.getShippingCompName() == null : this.getShippingCompName().equals(other.getShippingCompName()))
            && (this.getShippingSn() == null ? other.getShippingSn() == null : this.getShippingSn().equals(other.getShippingSn()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getShippingTime() == null ? other.getShippingTime() == null : this.getShippingTime().equals(other.getShippingTime()))
            && (this.getReceiveTime() == null ? other.getReceiveTime() == null : this.getReceiveTime().equals(other.getReceiveTime()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getShippingCompName() == null) ? 0 : getShippingCompName().hashCode());
        result = prime * result + ((getShippingSn() == null) ? 0 : getShippingSn().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getShippingTime() == null) ? 0 : getShippingTime().hashCode());
        result = prime * result + ((getReceiveTime() == null) ? 0 : getReceiveTime().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", customerId=").append(customerId);
        sb.append(", shippingCompName=").append(shippingCompName);
        sb.append(", shippingSn=").append(shippingSn);
        sb.append(", createTime=").append(createTime);
        sb.append(", shippingTime=").append(shippingTime);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}